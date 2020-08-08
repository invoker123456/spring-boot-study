package net.invoker.log.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: invoker
 * @Date: 2020/8/7 下午5:54
 * @Description：
 */
@RestController
public class indexController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    String index() {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return "index";
    }
}
