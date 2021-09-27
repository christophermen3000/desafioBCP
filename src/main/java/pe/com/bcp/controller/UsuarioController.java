package pe.com.bcp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import pe.com.bcp.dao.UsuarioDAO;
import pe.com.bcp.dao.TipoCambioDAO;
import pe.com.bcp.model.Usuario;
import pe.com.bcp.model.Tipocambio;

@RestController
public class UsuarioController {

	private UsuarioDAO usuarioRepository;
	private TipoCambioDAO tipoCambioRepository;
	
	public UsuarioController(UsuarioDAO usuarioRepository, TipoCambioDAO tipoCambioRepository) {
		this.usuarioRepository = usuarioRepository;
		this.tipoCambioRepository = tipoCambioRepository;
	}
	
	@PostMapping("/tipocambio/")
	public Mono<Tipocambio> saveTipoCambio(@RequestBody Tipocambio tipoCambio) {
		return tipoCambioRepository.save(tipoCambio);
	}
	
	@GetMapping("/tiposcambio/")
	public Flux<Tipocambio> getAllTipoCambio() {
		return tipoCambioRepository.findAll();
	}
	
	@GetMapping("/tipocambio")
	public Tipocambio getTipoCambio(@RequestParam String monedaorigen, @RequestParam String monedadestino, @RequestParam double monto) {
		Mono<Tipocambio> tipocambioCons = tipoCambioRepository.findByMonedaorigenAndMonedadestino(monedaorigen, monedadestino);
		Tipocambio tipocambio = tipocambioCons.block();
		tipocambio.setMonto(tipocambio.getTipocambio() * monto);
		return tipocambio;
	}
	

}

