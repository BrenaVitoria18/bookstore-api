package com.vbs.bookstore.controller;

import com.vbs.bookstore.dto.CategoriaDTO;
import com.vbs.bookstore.model.CategoriaModel;
import com.vbs.bookstore.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController // Controlador REST
@RequestMapping(value = "/categorias") //endpoint inicial

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
}
