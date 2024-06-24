package com.vbs.bookstore.dto;

import com.vbs.bookstore.model.CategoriaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class CategoriaDTO implements Serializable {
    private Integer id;
    private String nome;
    private String descricao;

    public CategoriaDTO(CategoriaModel categoriaModel) {
        this.id = categoriaModel.getId();
        this.nome = categoriaModel.getNome();
        this.descricao = categoriaModel.getDescricao();
    }
}
