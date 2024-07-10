package desafio.frumhub.dominio.user;

public record DadosUsuario(Long id, String name, String email) {

    public DadosUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}
