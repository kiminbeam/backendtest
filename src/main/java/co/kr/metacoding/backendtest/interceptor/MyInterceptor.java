package co.kr.metacoding.backendtest.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //요청 URL 추출
        String requestURI = request.getRequestURI();
        System.out.println("RequestURI: " + requestURI);

        //URL 검증
        if (containsDisallowedCharacters(requestURI)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("허용되지 않은 URL입니다.");
            return false; // 요청 처리 중단
        }
        return true;
    }

    private boolean containsDisallowedCharacters(String url) {
        // 허용된 문자: 알파벳, 숫자, 허용 특수문자(?, &, =, :, //)
        return !url.matches("^[a-zA-Z0-9/?&=:]+$");
    }
}
