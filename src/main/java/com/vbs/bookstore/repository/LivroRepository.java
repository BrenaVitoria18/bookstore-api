package com.vbs.bookstore.repository;

import com.vbs.bookstore.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Integer> {
    @Query("SELECT obj FROM livro obj WHERE obj.categoria.id = :idCategoria ORDER BY titulo")
    List<LivroModel> buscaLivrosPorCategorias(@Param(value = "idCategoria") Integer idCategoria);
}
