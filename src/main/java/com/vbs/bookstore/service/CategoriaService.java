package com.vbs.bookstore.service;

import com.vbs.bookstore.dto.CategoriaDTO;
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

    public CategoriaModel atualizarCategoria(Integer id, CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaModel = buscaPorId(id);
        categoriaModel.setNome(categoriaDTO.getNome());
        categoriaModel.setDescricao(categoriaDTO.getDescricao());
        return categoriaRepository.save(categoriaModel);
    }

    public void deletarCategoria(Integer id) {
        buscaPorId(id);
        categoriaRepository.deleteById(id);
    }
}
