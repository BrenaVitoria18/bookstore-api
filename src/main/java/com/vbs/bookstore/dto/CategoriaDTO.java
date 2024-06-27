package com.vbs.bookstore.dto;

import com.vbs.bookstore.model.CategoriaModel;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class CategoriaDTO implements Serializable {
    private Integer id;
    @NotEmpty(message = "Campo nome é obrigatorio")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 a 100 caracteres")
    private String nome;

    @NotEmpty(message = "Campo nome é obrigatorio")
    @Length(min = 3, max = 200, message = "O campo nome deve ter entre 3 a 200 caracteres")
    private String descricao;

    public CategoriaDTO(CategoriaModel categoriaModel) {
        this.id = categoriaModel.getId();
        this.nome = categoriaModel.getNome();
        this.descricao = categoriaModel.getDescricao();
    }
}
