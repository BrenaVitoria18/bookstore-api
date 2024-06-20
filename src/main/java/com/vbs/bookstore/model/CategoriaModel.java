package com.vbs.bookstore.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "categoria") //informa hibernate e jpa que a classe categoria é uma entidade, e que pode criar uma tabela no banco de dados

public class CategoriaModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List <LivroModel> livros = new ArrayList<>();

    public CategoriaModel(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
}
