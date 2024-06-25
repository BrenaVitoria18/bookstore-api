package com.vbs.bookstore.service;

import com.vbs.bookstore.model.CategoriaModel;
import com.vbs.bookstore.model.LivroModel;
import com.vbs.bookstore.repository.LivroRepository;
import com.vbs.bookstore.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public LivroModel buscaLivroPorId(Integer id){
        Optional<LivroModel> livro = livroRepository.findById(id);
        return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! Id: " + id + ", Tipo: " + LivroModel.class.getName()));
    }
}
