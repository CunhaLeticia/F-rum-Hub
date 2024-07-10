package desafio.frumhub.dominio.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String curso
) {
}
