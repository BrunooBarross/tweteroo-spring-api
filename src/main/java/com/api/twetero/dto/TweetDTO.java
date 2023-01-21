package com.api.twetero.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TweetDTO( 
    @NotBlank(message = "O campo tweet não pode ser vazio")
    @Size(max = 280, message = "Um tweet não pode ser maior que 280 caracteres")
    String text
    ) {
    
}
