package com.vbs.bookstore.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

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

    @NotEmpty(message = "Campo nome é obrigatorio")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 a 100 caracteres")
    private String nome;

    @NotEmpty(message = "Campo nome é obrigatorio")
    @Length(min = 3, max = 200, message = "O campo nome deve ter entre 3 a 200 caracteres")
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List <LivroModel> livros = new ArrayList<>();

    public CategoriaModel(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
}
