package co.kr.metacoding.backendtest.error;

import co.kr.metacoding.backendtest.util.Resp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(Exception400.class)
    public ResponseEntity<?> err400(Exception400 e){
        ResponseEntity rn = new ResponseEntity(Resp.fail(e.getMessage()), HttpStatus.BAD_REQUEST);
        return rn;
    }

    @ExceptionHandler(Exception404.class)
    public ResponseEntity<?> err404(Exception404 e){
        ResponseEntity rn = new ResponseEntity(Resp.fail(e.getMessage()), HttpStatus.NOT_FOUND);
        return rn;
    }

}
