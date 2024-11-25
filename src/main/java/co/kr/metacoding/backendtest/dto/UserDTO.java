package co.kr.metacoding.backendtest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String name;

    public UserDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
