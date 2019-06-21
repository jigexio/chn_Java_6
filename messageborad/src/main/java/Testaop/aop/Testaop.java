package Testaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Testaop {
    private static Logger logger = LoggerFactory.getLogger(Testaop.class);

    @Pointcut("execution(public * com.chaojilaji.testaop.controller.TestController.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("who: {}", joinPoint.getSignature().getDeclaringTypeName() + " " + joinPoint.getSignature().getName());
        //
    }

    @After("log()")
    public void doAfter() {

    }

    @AfterReturning(returning = "obj", pointcut = "log()")
    public void doAfterReturning(Object obj) {
        logger.info("result: {}", obj);
    }

}
