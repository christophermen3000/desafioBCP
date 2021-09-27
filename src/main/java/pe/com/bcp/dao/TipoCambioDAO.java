package pe.com.bcp.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import pe.com.bcp.model.Tipocambio;

public interface TipoCambioDAO extends ReactiveCrudRepository<Tipocambio, Long> {

	Mono<Tipocambio> findByMonedaorigenAndMonedadestino(String monedaorigen, String monedadestino);
}