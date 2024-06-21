package com.vbs.bookstore.service;

import com.vbs.bookstore.model.CategoriaModel;
import com.vbs.bookstore.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaModel buscaPorId(Integer id){
        Optional<CategoriaModel> categoriaExiste = categoriaRepository.findById(id);
        return categoriaExiste.orElse(null);
    }
}
