package com.example.demo.dto.user;

import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDataDTO {
    private UUID idUser;
    private String userName;
    private String password;

    public UserDataDTO(User user) {
        this.idUser = user.getId();
        this.userName = user.getUsername();
        this.password = user.getPassword();
    }
}
