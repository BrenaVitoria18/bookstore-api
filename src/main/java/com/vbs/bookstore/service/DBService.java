package com.vbs.bookstore.service;

import com.vbs.bookstore.model.CategoriaModel;
import com.vbs.bookstore.model.LivroModel;
import com.vbs.bookstore.repository.CategoriaRepository;
import com.vbs.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service // Classe que irá salvar o dados no banco de dados
public class DBService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados(){

        CategoriaModel categoriaModel = new CategoriaModel(null, "Informática", "Livros de TI");
        CategoriaModel categoriaModel2 = new CategoriaModel(null, "Ficção Cientifica", "Ficção Cientifica");
        CategoriaModel categoriaModel3 = new CategoriaModel(null, "Romance", "Romance");

        LivroModel livroModel = new LivroModel(null, "Clean code", "Robert Martin", "Lorem ipsum", categoriaModel);
        LivroModel livroModel2 = new LivroModel(null, "The time machine", "H.G. WElls", "Lorem ipsum", categoriaModel2);
        LivroModel livroModel3= new LivroModel(null, "Titanic", "James Cameron", "Lorem ipsum", categoriaModel3);

        categoriaModel.getLivros().addAll(Arrays.asList(livroModel));
        categoriaModel2.getLivros().addAll(Arrays.asList(livroModel2));
        categoriaModel3.getLivros().addAll(Arrays.asList(livroModel3));



        categoriaRepository.saveAll(Arrays.asList(categoriaModel,categoriaModel2, categoriaModel3));
        livroRepository.saveAll(Arrays.asList(livroModel, livroModel2, livroModel3));
    }

}
