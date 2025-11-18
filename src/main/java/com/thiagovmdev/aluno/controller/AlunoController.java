package com.thiagovmdev.aluno.controller;


import com.thiagovmdev.aluno.dto.AlunoRequest;
import com.thiagovmdev.aluno.entity.Aluno;
import com.thiagovmdev.aluno.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping(value = "/criar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> criar(
            @RequestPart("dados") AlunoRequest dto,
            @RequestPart(value = "foto", required = false) MultipartFile foto
    ) throws Exception {

        alunoService.criarAluno(dto, foto);
        return ResponseEntity.ok("Aluno cadastrado com sucesso!");
    }
}

