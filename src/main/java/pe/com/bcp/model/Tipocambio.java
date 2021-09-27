package pe.com.bcp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("Tipocambio")
public class Tipocambio {

	@Id
	private int id;

	private String monedaorigen;
	
	private String monedadestino;

	private double tipocambio;
	
	private double monto;

	
}
