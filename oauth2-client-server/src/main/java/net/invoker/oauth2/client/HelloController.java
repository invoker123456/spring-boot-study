package net.invoker.oauth2.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: invoker
 * @Date: 2020/8/10 上午11:43
 * @Description：
 */
@Controller
public class HelloController {

//    private RestTemplate restTemplate;
//    private ClientHttpRequestFactory factory;
//
//    @Autowired
//    public void setFactory() {
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setReadTimeout(5000);//ms
//        factory.setConnectTimeout(15000);//ms
//        this.factory = factory;
//    }
//
//    @Autowired
//    public void setRestTemplate() {
//        this.restTemplate = new RestTemplate(this.factory);
//    }
//
//    @GetMapping("/index.html")
//    public String hello(String code, Model model) {
//        if (code != null) {
//            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//            map.add("code", code);
//            map.add("client_id", "javaboy");
//            map.add("client_secret", "123");
//            map.add("redirect_uri", "http://localhost:8082/index.html");
//            map.add("grant_type", "authorization_code");
//            Map<String, String> resp = restTemplate.postForObject("http://localhost:8080/oauth/token", map, Map.class);
//            String access_token = resp.get("access_token");
//            System.out.println(access_token);
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Authorization", "Bearer " + access_token);
//            HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
//            ResponseEntity<String> entity = restTemplate.exchange("http://localhost:8081/admin/hello", HttpMethod.GET, httpEntity, String.class);
//            model.addAttribute("msg", entity.getBody());
//        }
//        return "index";
//    }

    @Autowired
    TokenTask tokenTask;

    @GetMapping("/index.html")
    public String hello(String code, Model model) {
        model.addAttribute("msg", tokenTask.getData(code));
        return "index";
    }
}
