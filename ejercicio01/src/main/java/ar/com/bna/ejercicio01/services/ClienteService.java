package ar.com.bna.ejercicio01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.bna.ejercicio01.kafka.StringPublisher;
import ar.com.bna.ejercicio01.model.Cliente;
import ar.com.bna.ejercicio01.repository.ClienteRepository;

@Service("ClienteService")
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private StringPublisher stringPublisher;
	
	public List<Cliente> list() {
		stringPublisher.produce("list");
		return clienteRepository.findAll();
	}

	public Optional<Cliente> getClienteById(int id) {
		stringPublisher.produce("getClienteById " + id);
		return clienteRepository.findById(id);
	}

	public Optional<Cliente> getClienteByCuil(String cuil) {
		stringPublisher.produce("getClienteByCuil " + cuil);
		return clienteRepository.findByCuil(cuil);
	}

	public Cliente addCliente(Cliente cliente) {
		stringPublisher.produce("addCliente " + cliente.toString());
		return clienteRepository.save(cliente);
	}

	public Cliente updateCliente(Cliente cliente) {
		stringPublisher.produce("updateCliente " + cliente.toString());
		Optional<Cliente> clienteEncontrado = clienteRepository.findById(cliente.getId());
		return clienteEncontrado.isPresent() ? clienteRepository.save(cliente): null ;
	}
}
