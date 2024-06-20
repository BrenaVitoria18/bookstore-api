package com.vbs.bookstore.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LivroModel {
    private Integer id;
    private String titulo;
    private String nomeAutor;
    private String texto;

    private CategoriaModel categoriaModel;
}
