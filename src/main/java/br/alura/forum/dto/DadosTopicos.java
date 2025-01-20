package br.alura.forum.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosTopicos(String  titulo, String mensagem, String dadaCriaco, String estadoDoTopico, String autor, String curso) {
}
