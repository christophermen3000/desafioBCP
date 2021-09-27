package pe.com.bcp.service;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.com.bcp.dao.UsuarioDAO;
import pe.com.bcp.dao.TipoCambioDAO;
import pe.com.bcp.model.Usuario;
import reactor.core.publisher.Mono;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

	private UsuarioDAO usuarioRepository;
	private TipoCambioDAO tipoCambioRepository;

	public UsuarioDetailsServiceImpl(UsuarioDAO usuarioRepository, TipoCambioDAO tipoCambioRepository) {
		this.usuarioRepository = usuarioRepository;
		this.tipoCambioRepository = tipoCambioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Mono<Usuario> usuario = usuarioRepository.findByUsername(username);
		Usuario user = usuario.block();
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(user.getUsername(), user.getPassword(), emptyList());
	}
}
