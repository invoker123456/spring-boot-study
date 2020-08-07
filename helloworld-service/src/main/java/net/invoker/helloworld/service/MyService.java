package net.invoker.helloworld.service;

import org.springframework.stereotype.Service;

/**
 * @Author: invoker
 * @Date: 2020/8/7 下午12:52
 * @Description：
 */
@Service
public class MyService {
    public String message() {
        return "this is module for helloworld.service method message";
    }
}
