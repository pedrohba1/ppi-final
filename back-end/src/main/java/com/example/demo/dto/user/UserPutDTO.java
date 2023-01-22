package com.example.demo.dto.user;

import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserPutDTO {
    private String userName;
    private String password;

    public User toUser(User user) {
        User putUser = new User();
        putUser.setIdUser(user.getIdUser());

        putUser.setUserName(userName);
        putUser.setPassword(password);

        return putUser;
    }
}
