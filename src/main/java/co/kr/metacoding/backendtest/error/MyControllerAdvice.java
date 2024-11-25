package co.kr.metacoding.backendtest.error;

import co.kr.metacoding.backendtest.util.Resp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(Exception400.class)
    public ResponseEntity<Map<String, String>> err400(Exception400 e){
        Map<String, String> body = new HashMap<>();
        body.put("reason", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception404.class)
    public ResponseEntity<Map<String, String>> err404(Exception404 e){
        Map<String, String> body = new HashMap<>();
        body.put("reason", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}
