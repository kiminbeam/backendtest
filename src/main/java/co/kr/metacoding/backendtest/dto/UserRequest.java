package co.kr.metacoding.backendtest.dto;

import co.kr.metacoding.backendtest.entity.User;
import lombok.Data;

public class UserRequest {

    @Data
    public static class PostDTO{
        private String name;

        public User toEntity(){
            User u = new User(null ,name);
            return u;
        }
    }

    @Data
    public static class UpdateDTO{
        private String name;
    }

}
