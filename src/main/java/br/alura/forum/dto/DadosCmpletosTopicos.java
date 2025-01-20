package br.alura.forum.dto;

import br.alura.forum.model.Topicos;

public record DadosCmpletosTopicos(Long id, String  titulo, String mensagem, String dadaCriaco, String estadoDoTopico, String autor, String curso) {


    public DadosCmpletosTopicos(Topicos topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getEstadoDoTopico(), topico.getAutor(), topico.getCurso());
    }
}

