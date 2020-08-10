package net.invoker.aoplog.controller;

import net.invoker.aoplog.annotation.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: invoker
 * @Date: 2020/8/8 上午11:46
 * @Description：控制层 Controller 类
 */
@Controller
public class IndexController {
    @Log("日志注解，配合WebAspect记录请求前、请求后、请求过程")
    @RequestMapping("/log")
    @ResponseBody
    public String log(String name) {
        return "log";
    }
}
