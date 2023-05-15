package ar.com.bna.ejercicio01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.bna.ejercicio01.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    public Optional<Cliente> findByCuil(String cuil);
}
