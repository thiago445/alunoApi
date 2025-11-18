package com.thiagovmdev.aluno.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alunos",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "usuario_acesso"),
                @UniqueConstraint(columnNames = "email_aluno")
        })
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAluno;

    @Column(name = "nome_completo", nullable = false, length = 150)
    private String nomeCompleto;

    @Column(name = "usuario_acesso", nullable = false, length = 50, unique = true)
    private String usuarioAcesso;

    @Column(name = "senha_hash", nullable = false, length = 100)
    private String senhaHash;

    @Column(name = "email_aluno", nullable = false, length = 120, unique = true)
    private String emailAluno;

    @Column(name = "observacao", length = 255)
    private String observacao;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] foto;


    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @PrePersist
    protected void onCreate() {
        dataCadastro = LocalDateTime.now();
    }

    public Aluno() {
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Aluno(Long idAluno, String nomeCompleto, String usuarioAcesso, String senhaHash, String emailAluno, String observacao, byte[] foto, LocalDateTime dataCadastro) {
        this.idAluno = idAluno;
        this.nomeCompleto = nomeCompleto;
        this.usuarioAcesso = usuarioAcesso;
        this.senhaHash = senhaHash;
        this.emailAluno = emailAluno;
        this.observacao = observacao;
        this.foto = foto;
        this.dataCadastro = dataCadastro;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getUsuarioAcesso() {
        return usuarioAcesso;
    }

    public void setUsuarioAcesso(String usuarioAcesso) {
        this.usuarioAcesso = usuarioAcesso;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public String getEmailAluno() {
        return emailAluno;
    }

    public void setEmailAluno(String emailAluno) {
        this.emailAluno = emailAluno;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


    // Getters e Setters
}
