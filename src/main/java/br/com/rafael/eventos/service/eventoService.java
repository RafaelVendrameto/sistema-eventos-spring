package br.com.rafael.eventos.service;

import br.com.rafael.eventos.model.eventoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.rafael.eventos.repository.eventoRepository;

import java.time.LocalDate;
import java.util.Optional;


@Service
public class eventoService {

    @Autowired
    private eventoRepository repository;

    public eventoModel criarEvento(eventoModel model){
        model.setDataCriacao(LocalDate.now());
        model.setAtivo(Boolean.TRUE);
        return repository.save(model);
    }

    public Iterable<eventoModel> listarEventos() {
        Iterable<eventoModel> eventos = repository.findAll();
        return eventos;
    }

    public eventoModel listarEvento(String nome) {
        Optional<eventoModel> evento = repository.findBynome(nome);
        if (evento.isPresent()){
            return evento.get();
        }
        return null;
    }
}
