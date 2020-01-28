package br.com.rafael.eventos.service;

import br.com.rafael.eventos.model.eventoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.rafael.eventos.repository.enventoRepository;

import java.time.LocalDate;


@Service
public class eventoService {

    @Autowired
    private enventoRepository repository;

    public eventoModel criarEvento(eventoModel model){
        model.setDataCriacao(LocalDate.now());
        model.setAtivo(Boolean.TRUE);
        return repository.save(model);
    }
}
