package com.example.demo.dto.user;

import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserPutDTO {
    private String userName;
    private String password;

    public User toUser(Optional<User> user) {
        User putUser = new User();
        putUser.setIdUser(user.get().getIdUser());

        putUser.setPassword(password);

        return putUser;
    }
}
