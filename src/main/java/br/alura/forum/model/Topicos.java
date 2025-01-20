package br.alura.forum.model;

import br.alura.forum.dto.DadosTopicos;
import br.alura.forum.dto.DadosUpdaTopico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;


@Table(name = "topicos")
@Entity(name = "Topicos")
@Getter

@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topicos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private String dataCriacao;
    private String estadoDoTopico;
    private String autor;
    private String curso;

    private Boolean ativo;


    public Topicos(){}

    private LocalDateTime data;


    public Topicos(DadosTopicos dados) {
        this.ativo = true;
       this.titulo = dados.titulo();
       this.mensagem = dados.mensagem();
       this.dataCriacao = String.valueOf(data.now());
       this.estadoDoTopico = dados.estadoDoTopico();
       this.autor = dados.autor();
       this.curso = dados.curso();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public String getEstadoDoTopico() {
        return estadoDoTopico;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }

    public void excluir() {
        this.ativo = false;
    }


    public void atualizarInformacoes(@Valid DadosUpdaTopico dados) {
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();;
        }
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }

    }




}
