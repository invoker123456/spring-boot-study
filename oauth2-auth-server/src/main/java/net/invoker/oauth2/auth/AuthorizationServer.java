package net.invoker.oauth2.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @Author: invoker
 * @Date: 2020/8/10 上午11:43
 * @Description：
 */
@EnableAuthorizationServer
@Configuration
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
    @Autowired
    TokenStore tokenStore;
    @Autowired
    DataSource dataSource;
    @Autowired
    JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    CustomAdditionalInformation customAdditionalInformation;

    // 用自定义的 ClientDetailsService 取代 系统生成的
    @Bean
    ClientDetailsService clientDetailsService() {
        return new JdbcClientDetailsService(dataSource);
    }

    @Bean
    AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices services = new DefaultTokenServices();
        services.setClientDetailsService(clientDetailsService());
        services.setSupportRefreshToken(true);
        services.setTokenStore(tokenStore);
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtAccessTokenConverter, customAdditionalInformation));
        services.setTokenEnhancer(tokenEnhancerChain);
        return services;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService());

//        clients.inMemory()
//                .withClient("javaboy")
//                .secret(new BCryptPasswordEncoder().encode("123"))
//                .resourceIds("res1")
//                .authorizedGrantTypes("authorization_code", "refresh_token")
//                .scopes("all")
//                .redirectUris("http://localhost:8082/index.html");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authorizationCodeServices(authorizationCodeServices())
                .tokenServices(tokenServices());
    }

    @Bean
    AuthorizationCodeServices authorizationCodeServices() {
        return new InMemoryAuthorizationCodeServices();
    }
}
