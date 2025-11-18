package com.thiagovmdev.aluno.dto;


import jakarta.validation.constraints.*;

public record AlunoRequest(

        @NotBlank @Size(max = 150)
        String nome_completo,

        @NotBlank @Size(max = 50)
        String usuario_acesso,

        @NotBlank @Size(min = 8, max = 100)
        String senha,

        @NotBlank @Email @Size(max = 120)
        String email_aluno,

        @Size(max = 255)
        String observacao
) { }
