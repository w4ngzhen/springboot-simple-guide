package com.compilemind.guide.chapter04_05.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 定义一个日志切面
 */
@Aspect
@Component // 切面不是Bean，需要添加注解
public class LogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 定义切点表明要通知的地方
     * 这里使用了pointcut expression表达式，具体语法请自行搜索
     * 这里解释为包 com.compilemind.guide包以及子包的所有类的所有公共方法
     */
    @Pointcut("execution(* com.compilemind.guide..*.*(..))")
    public void webLog() {
    }

    /**
     * 指代上面的切点：webLog，并且是调用前执行
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        HttpServletRequest request = requestAttributes.getRequest();
        LOGGER.info("发生请求：" + request.getRequestURI());
        LOGGER.info("调用方法：" + joinPoint.getSignature());
    }

    /**
     * 一个关于对应切点的环绕执行的处理
     */
    @Around("webLog()")
    public Object around(ProceedingJoinPoint joinPoint) {
        long currentTimeMillis = System.currentTimeMillis();
        // 调用参数
        Object[] invokeArgs = joinPoint.getArgs();
        // 返回数据
        Object returnObj;
        try {
            // 执行对应的方法，得到结果
            returnObj = joinPoint.proceed(invokeArgs);
        } catch (Throwable e) {
            LOGGER.error("统计某方法执行耗时环绕通知出错", e);
            return null;
        }
        LOGGER.info("处理耗时：{} ms", System.currentTimeMillis() - currentTimeMillis);
        return returnObj;
    }
}
