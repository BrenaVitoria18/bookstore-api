package com.vbs.bookstore.controller;

import com.vbs.bookstore.dto.LivroDTO;
import com.vbs.bookstore.model.LivroModel;
import com.vbs.bookstore.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*") //Permite que receba solicitações de qualquer fonte
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

    @PutMapping(value = "/{id}")
    public ResponseEntity<LivroModel> atualizarLivro(@PathVariable Integer id, @Valid @RequestBody LivroModel livroModel){
        LivroModel livroModel1 = livroService.atualizarLivro(id, livroModel);
        return ResponseEntity.ok().body(livroModel1);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<LivroModel> atualizarLivroPatch(@PathVariable Integer id, @Valid @RequestBody LivroModel livroModel){
        LivroModel livroModel1 = livroService.atualizarLivro(id, livroModel);
        return ResponseEntity.ok().body(livroModel1);
    }

    @PostMapping
    public ResponseEntity<LivroModel> salvarLivro (@RequestParam(value = "categoria", defaultValue = "0") Integer idCategoria,
                                                   @Valid
                                                   @RequestBody LivroModel livroModel){
        LivroModel livroModel1 = livroService.salvarLivro(idCategoria, livroModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(livroModel1.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Integer id){
        livroService.deletarlivro(id);
        return ResponseEntity.noContent().build();
    }
}
