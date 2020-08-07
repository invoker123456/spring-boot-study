package net.invoker.helloworld.controller;

import net.invoker.helloworld.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: invoker
 * @Date: 2020/8/7 下午12:57
 * @Description：
 */
@RestController
public class IndexController {
    @Autowired
    MyService myService;

    @GetMapping("/say")
    public String say() {
        return myService.message();
    }
}
