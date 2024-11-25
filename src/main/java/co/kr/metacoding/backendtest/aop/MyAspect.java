package co.kr.metacoding.backendtest.aop;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
