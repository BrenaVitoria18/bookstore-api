package com.vbs.bookstore.service;

import com.vbs.bookstore.service.exception.ObjectNotFoundException;
import com.vbs.bookstore.model.CategoriaModel;
import com.vbs.bookstore.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaModel buscaPorId(Integer id){
        Optional<CategoriaModel> categoriaExiste = categoriaRepository.findById(id);
        return categoriaExiste.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + CategoriaModel.class.getName()));
    }

    public List<CategoriaModel> buscaTodasCategorias(){
        return categoriaRepository.findAll();
    }

    public CategoriaModel criarCategoria (CategoriaModel categoriaModel){
        categoriaModel.setId(null);
        return categoriaRepository.save(categoriaModel);
    }
}
