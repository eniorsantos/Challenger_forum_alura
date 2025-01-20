package br.alura.forum.dto;

import br.alura.forum.model.Topicos;

public record DadosCadastroTopicos(Long id, String titulo, String mensagem, String dataCriacao) {

    public DadosCadastroTopicos(Topicos topicos){
        this(topicos.getId(), topicos.getTitulo(), topicos.getMensagem(), topicos.getDataCriacao());
    }
}
