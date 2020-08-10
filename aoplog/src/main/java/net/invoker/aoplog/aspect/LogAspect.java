package net.invoker.aoplog.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: invoker
 * @Date: 2020/8/8 上午11:45
 * @Description：自定义日志拦截注解触发条件、环绕增强（在请求前和请求后的执行逻辑）
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 这里指定使用 @annotation 指定com.fishpro.aoplog.annotation.Log log注解
     */
    @Pointcut("@annotation(net.invoker.aoplog.annotation.Log)")
    public void logPointCut() {

    }

    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //异步保存日志 这里是文本日志

        return result;
    }

    void saveLog(ProceedingJoinPoint joinPoint, long time) throws InterruptedException {

    }
}
