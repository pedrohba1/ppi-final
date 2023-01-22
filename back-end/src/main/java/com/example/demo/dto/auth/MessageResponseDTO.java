package com.example.demo.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Data
@Builder
public class MessageResponseDTO {
    private String message;

    public MessageResponseDTO(String message){
        this.message = message;

    }
}
