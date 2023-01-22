package com.example.demo.dto.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserCreationDataDTO {
    private String userName;
    private String password;
}
