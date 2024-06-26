package com.vbs.bookstore.controller.exception;

import com.vbs.bookstore.dto.LivroDTO;
import com.vbs.bookstore.model.LivroModel;
import com.vbs.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<LivroDTO>> listaTodosOsLivros (@RequestParam(value = "categoria", defaultValue = "0") Integer idCategoria){
        List<LivroModel> lista = livroService.buscaTodosOsLivros(idCategoria);
        List<LivroDTO>listaDTO = lista.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        //localhost:8080/livros?categoria=1
        return ResponseEntity.ok().body(listaDTO);
    }
}
