package br.com.rafael.eventos.repository;

import br.com.rafael.eventos.model.eventoModel;
import org.springframework.data.repository.CrudRepository;

public interface enventoRepository extends CrudRepository<eventoModel, String> {
}
