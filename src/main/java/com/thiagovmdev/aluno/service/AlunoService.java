package com.thiagovmdev.aluno.service;



import com.thiagovmdev.aluno.dto.AlunoRequest;
import com.thiagovmdev.aluno.entity.Aluno;
import com.thiagovmdev.aluno.repository.AlunoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AlunoService {

    private final AlunoRepository repo;
    private final PasswordEncoder encoder;

    public AlunoService(AlunoRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public void criarAluno(AlunoRequest dto, MultipartFile foto) throws Exception {

        Aluno aluno = new Aluno();
        aluno.setNomeCompleto(dto.nome_completo());
        aluno.setUsuarioAcesso(dto.usuario_acesso());
        aluno.setEmailAluno(dto.email_aluno());
        aluno.setObservacao(dto.observacao());
        aluno.setSenhaHash(encoder.encode(dto.senha()));

        if (foto != null && !foto.isEmpty()) {
            aluno.setFoto(foto.getBytes());
        }

        repo.save(aluno);
    }
}
