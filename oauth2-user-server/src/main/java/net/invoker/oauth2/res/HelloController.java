package net.invoker.oauth2.res;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: invoker
 * @Date: 2020/8/10 上午11:43
 * @Description：
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "admin";
    }
}
