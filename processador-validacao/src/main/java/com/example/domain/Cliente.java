package com.example.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {

    @NotNull
    @Size(min = 1, max = 100)
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Nome deve conter apenas letras e espaços")
    private String nome;
    @NotNull
    @Range(min = 18, max = 200)
    private String idade;
    @NotNull
    @Size(min = 1, max = 50)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email inválido")
    private String email;

}
