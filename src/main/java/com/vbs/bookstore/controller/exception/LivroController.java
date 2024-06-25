package com.vbs.bookstore.controller.exception;

import com.vbs.bookstore.model.LivroModel;
import com.vbs.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<LivroModel> listaLivroPorId(@PathVariable Integer id){
        LivroModel livroModel = livroService.buscaLivroPorId(id);
        return ResponseEntity.ok().body(livroModel);
    }
}
