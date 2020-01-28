package br.com.rafael.eventos.controller;

import br.com.rafael.eventos.model.eventoModel;
import br.com.rafael.eventos.service.eventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class eventoController {
    @Autowired
    private eventoService service;

    @GetMapping
    public String mostrarHome(){
        return "index";
    }

    @GetMapping("/cadastro")
    public String paginaCadastro(){
        return "cadastro";
    }

    @PostMapping("/resposta")
    public String paginaResposta(eventoModel model){
        service.criarEvento(model);
        return "resposta";

    }
}
