package br.com.rafael.eventos.repository;

import br.com.rafael.eventos.model.eventoModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface eventoRepository extends CrudRepository<eventoModel, String> {
    Optional<eventoModel> findBynome(String nome);
}
