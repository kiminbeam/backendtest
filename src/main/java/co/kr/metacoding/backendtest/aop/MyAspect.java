package co.kr.metacoding.backendtest.aop;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.logging.Logger;
import java.util.regex.Pattern;

@Component
@Aspect
public class MyAspect {

    @Autowired
    HttpServletRequest httpServletRequest;

    public MyAspect(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object getUserAgent(ProceedingJoinPoint joinPoint) throws Throwable {

        String userAgent = httpServletRequest.getHeader("User-Agent");
        System.out.println("User-Agent: " + userAgent);
        Object ob = joinPoint.proceed();

        return ob;
    }

}
