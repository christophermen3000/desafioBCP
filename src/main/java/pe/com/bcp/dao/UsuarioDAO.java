package pe.com.bcp.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import pe.com.bcp.model.Usuario;
import reactor.core.publisher.Mono;

public interface UsuarioDAO extends ReactiveCrudRepository<Usuario, Long> {

	Mono<Usuario> findByUsername(String username);
}