package desafio.frumhub.dominio.user;

import desafio.frumhub.infra.exception.RegisterException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;

    private final PasswordEncoder encoder;

    public DadosUsuario registrar(DadosRegistroUsuario dados) {
        Optional<Usuario> optionalUsuario = repository.findByEmail(dados.email());

        if(optionalUsuario.isPresent()) {
            throw new RegisterException("Email ja esta em uso");
        }

        Usuario usuario = repository.save(new Usuario(dados,encoder.encode(dados.password())));

        return new DadosUsuario(repository.save(usuario));
    }
}
