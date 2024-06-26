package com.vbs.bookstore.dto;


import com.vbs.bookstore.model.LivroModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class LivroDTO implements Serializable {
    private Integer id;
    private String titulo;
    private String nomeAutor;
    private String texto;

    public LivroDTO(LivroModel livroModel) {
        this.titulo = livroModel.getTitulo();
        this.id = livroModel.getId();
    }
}
