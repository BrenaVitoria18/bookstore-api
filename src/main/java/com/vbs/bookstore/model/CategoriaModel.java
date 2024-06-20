package com.vbs.bookstore.model;


import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class CategoriaModel {
    private Integer id;
    private String nome;
    private String descricao;

    private List <LivroModel> livros = new ArrayList<>();

    public CategoriaModel(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
}
