package net.invoker.oauth2.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Author: invoker
 * @Date: 2020/8/10 上午11:43
 * @Description：配置授权服务器
 */
@Configuration
public class AccessTokenConfig {
    private String SIGNING_KEY = "javaboy";

//    @Autowired
//    RedisConnectionFactory redisConnectionFactory;
//
//    @Bean
//    TokenStore tokenStore() {
//        // 直接存放到内存中
////        return new InMemoryTokenStore();
//        // 存入Redis
//        return new RedisTokenStore(redisConnectionFactory);
//    }

    @Bean
    TokenStore tokenStore() {
        // 使用 JWT
        // 使用了 JWT，access_token 实际上就不用存储了（无状态登录，服务端不需要保存信息），因为用户的所有信息都在 jwt 里边，所以这里配置的 JwtTokenStore 本质上并不是做存储
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }
}
