package com.vbs.bookstore;

import com.vbs.bookstore.model.CategoriaModel;
import com.vbs.bookstore.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
