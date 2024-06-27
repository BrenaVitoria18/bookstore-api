package com.vbs.bookstore.controller;

import com.vbs.bookstore.dto.CategoriaDTO;
import com.vbs.bookstore.model.CategoriaModel;
import com.vbs.bookstore.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController // Controlador REST
@RequestMapping(value = "/categorias") //endpoint inicial
@CrossOrigin("*") //Permite que receba solicitações de qualquer fonte
//localhost:8080/categorias/1
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaModel> buscaPorId(@PathVariable Integer id){
        CategoriaModel categoriaModel = categoriaService.buscaPorId(id);
        return ResponseEntity.ok().body(categoriaModel);

    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listaTodasAsCategorias(){
       List<CategoriaModel> listCategoria = categoriaService.buscaTodasCategorias();
       List<CategoriaDTO> listDto = listCategoria.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
       return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<CategoriaModel> criarCategoria(
            @Valid
            @RequestBody CategoriaModel categoriaModel){
        categoriaModel = categoriaService.criarCategoria(categoriaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoriaModel.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Integer id, @Valid @RequestBody CategoriaDTO categoriaDTO){
        CategoriaModel categoriaModel = categoriaService.atualizarCategoria(id, categoriaDTO);
        return ResponseEntity.ok().body(new CategoriaDTO(categoriaModel));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletaCategoria(@PathVariable Integer id){
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
