package co.kr.metacoding.backendtest.dto;

import lombok.Data;

public class UserDTO {
    private int id;
    private String name;

    public UserDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }


}
