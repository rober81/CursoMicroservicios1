package ar.com.bna.ejercicio01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.bna.ejercicio01.model.Cliente;
import ar.com.bna.ejercicio01.repository.ClienteRepository;

@Service("ClienteService")
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> list() {
		return clienteRepository.findAll();
	}

	public Optional<Cliente> getClienteById(int id) {
		return clienteRepository.findById(id);
	}

	public Optional<Cliente> getClienteByCuil(String cuil) {
		return clienteRepository.findByCuil(cuil);
	}

	public Cliente addCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente updateCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
