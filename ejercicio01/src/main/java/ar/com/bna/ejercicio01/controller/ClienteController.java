package ar.com.bna.ejercicio01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.bna.ejercicio01.model.Cliente;
import ar.com.bna.ejercicio01.services.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/health")
	public ResponseEntity<String> checkHealth() {
		return new ResponseEntity<>("Todo ok.", HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<Cliente>> getClientes() {
		return new ResponseEntity<>(clienteService.list(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable int id) {
		Optional<Cliente> clientes = clienteService.getClienteById(id);
		if (clientes.isPresent())
			return new ResponseEntity<>(clientes.get(), HttpStatus.OK);
		return new ResponseEntity<>(new Cliente(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
		Cliente clienteRespuesta = clienteService.addCliente(cliente);
		return new ResponseEntity<>(clienteRespuesta, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente, @PathVariable int id) {
		cliente.setId(id);
		Cliente clienteRespuesta = clienteService.updateCliente(cliente);
		return new ResponseEntity<>(clienteRespuesta, HttpStatus.OK);
	}

}
