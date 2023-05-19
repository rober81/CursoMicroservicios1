package ar.com.bna.ejercicio01.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private String cuil;
	private String tipoDocumento;
	private Integer nroDocumento;
	private boolean esEmpleadoBNA;
	private String paisOrigen;
	
}
