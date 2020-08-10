package net.invoker.securityjwt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: invoker
 * @Date: 2020/8/9 下午2:47
 * @Description：
 */
@RestController
public class HelloWorldController {
    @RequestMapping({"/hello"})
    public String firstPage() {
        return "Hello World";
    }
}
