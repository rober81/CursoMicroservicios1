package ar.com.bna.ejercicio01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.bna.ejercicio01.kafka.StringPublisher;
import ar.com.bna.ejercicio01.model.Cliente;
import ar.com.bna.ejercicio01.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("ClienteService")
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private StringPublisher stringPublisher;
	
	public List<Cliente> list() {
		stringPublisher.produce("list");
		List<Cliente> lista = clienteRepository.findAll();
		log.info("list -> " + lista.toString());
		return lista;
	}

	public Optional<Cliente> getClienteById(int id) {
		stringPublisher.produce("getClienteById " + id);
		Optional<Cliente> cliente = clienteRepository.findById(id);
		log.info("getClienteById -> " + cliente.toString());
		return cliente;
	}

	public Optional<Cliente> getClienteByCuil(String cuil) {
		stringPublisher.produce("getClienteByCuil " + cuil);
		Optional<Cliente> cliente = clienteRepository.findByCuil(cuil);
		log.info("getClienteByCuil -> " + cliente.toString());
		return cliente;
	}

	public Cliente addCliente(Cliente cliente) {
		stringPublisher.produce("addCliente " + cliente.toString());
		Cliente resultado = clienteRepository.save(cliente);
		log.info("addCliente -> " + resultado.toString());
		return resultado;
	}

	public Cliente updateCliente(Cliente cliente) {
		stringPublisher.produce("updateCliente " + cliente.toString());
		Optional<Cliente> clienteEncontrado = clienteRepository.findById(cliente.getId());
		Cliente resultado = clienteEncontrado.isPresent() ? clienteRepository.save(cliente): null ;
		log.info("updateCliente -> " + resultado.toString());
		return resultado;
	}
}
