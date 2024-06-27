package com.vbs.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity(name = "livro") //informa hibernate e jpa que a classe categoria é uma entidade, e que pode criar uma tabela no banco de dados
public class LivroModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo titulo é obrigatorio")
    @Length(min = 3, max = 50, message = "O campo nome deve ter entre 3 a 50 caracteres")
    private String titulo;

    @NotEmpty(message = "Campo nomeAutor é obrigatorio")
    @Length(min = 3, max = 50, message = "O campo nomeAutor deve ter entre 3 a 50 caracteres")
    private String nomeAutor;

    @NotEmpty(message = "Campo texto é obrigatorio")
    @Length(min = 10, max = 2000000, message = "O campo texto deve ter entre 10 a 2.000.000 caracteres")
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaModel categoria;
}
