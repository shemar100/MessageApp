package app.messages.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityChecker {
    public static final Logger logger = LoggerFactory.getLogger(SecurityChecker.class);

    @Pointcut("@annotation(SecurityCheck)")
    public void checkMethodSecurity() {}

    @Around("checkMethodSecurity()")
    public Object checkSecurity(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.debug("Checking Method security");
        //TODO: implement security checker aspect
        Object result = joinPoint.proceed();
        return result;
    }

}
