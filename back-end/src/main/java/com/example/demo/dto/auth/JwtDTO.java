package com.example.demo.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Data
@Builder
public class JwtDTO {
    private String token;

    public JwtDTO(String token){
        this.token = token;

    }
}
