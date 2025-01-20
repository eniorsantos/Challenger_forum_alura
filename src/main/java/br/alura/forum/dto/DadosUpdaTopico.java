package br.alura.forum.dto;

import jakarta.validation.constraints.NotNull;

public record DadosUpdaTopico( @NotNull
                               Long id,
                               String mensagem,
                               String titulo) {

}
