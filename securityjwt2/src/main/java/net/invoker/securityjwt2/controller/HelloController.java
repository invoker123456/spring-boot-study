package net.invoker.securityjwt2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: invoker
 * @Date: 2020/8/9 下午9:38
 * @Description：
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello jwt !";
    }

    @GetMapping("/admin")
    public String admin() {
        return "hello admin !";
    }
}
