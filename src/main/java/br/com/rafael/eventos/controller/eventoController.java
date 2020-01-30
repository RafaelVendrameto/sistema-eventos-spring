package br.com.rafael.eventos.controller;

import br.com.rafael.eventos.model.eventoModel;
import br.com.rafael.eventos.service.eventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


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

    @GetMapping("/eventos")
    public ModelAndView listarEventos(){
        ModelAndView pagina = new ModelAndView("listarEventos");
        Iterable<eventoModel> eventos = service.listarEventos();
        pagina.addObject("eventos", eventos);
        return pagina;
    }

    @GetMapping("/buscar")
    public String paginaBuscar(){
        return "buscar";
    }

    @GetMapping("/evento")
    public String listarEvento(@RequestParam ("nome") String nome, Model model){
        eventoModel evento = service.listarEvento(nome);
        if (evento != null) {
            model.addAttribute("evento", evento);
            return "listarEvento";
        }
        else {
            model.addAttribute("msg", "Evento " + nome + " não encontrado, tente novamente!");
            return "buscar";
        }
    }

    @GetMapping("/evento/{nome}")
    public String listarEventos(@PathVariable("nome") String nome, Model model){
        eventoModel evento = service.listarEvento(nome);
        if (evento != null) {
            model.addAttribute("evento", evento);
            return "listarEvento";
        }
        else {
            model.addAttribute("msg", "Evento " + nome + " não encontrado, tente novamente!");
            return "buscar";
        }
    }
}
