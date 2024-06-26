package com.vbs.bookstore.service;

import com.vbs.bookstore.model.CategoriaModel;
import com.vbs.bookstore.model.LivroModel;
import com.vbs.bookstore.repository.LivroRepository;
import com.vbs.bookstore.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public LivroModel buscaLivroPorId(Integer id){
        Optional<LivroModel> livro = livroRepository.findById(id);
        return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! Id: " + id + ", Tipo: " + LivroModel.class.getName()));
    }

    public List<LivroModel> buscaTodosOsLivros(Integer idCategoria) {
        categoriaService.buscaPorId(idCategoria);
        return livroRepository.buscaLivrosPorCategorias(idCategoria);
    }

    public LivroModel atualizarLivro(Integer id, LivroModel livroModel) {
        LivroModel livroModel1 = buscaLivroPorId(id);
        AtualizaDados(livroModel1, livroModel);

        return livroRepository.save(livroModel1);
    }

    private void AtualizaDados(LivroModel livroModel1, LivroModel livroModel) {
        livroModel1.setTitulo(livroModel.getTitulo());
        livroModel1.setNomeAutor(livroModel.getNomeAutor());
        livroModel1.setTexto(livroModel.getTexto());
    }

    public LivroModel salvarLivro(Integer idCategoria, LivroModel livroModel) {
        livroModel.setId(null);
        CategoriaModel categoriaModel = categoriaService.buscaPorId(idCategoria);
        livroModel.setCategoria(categoriaModel);

        return livroRepository.save(livroModel);
    }
}
