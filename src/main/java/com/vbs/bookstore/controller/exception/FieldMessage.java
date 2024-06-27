package com.vbs.bookstore.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldMessage implements Serializable {

    private String nomeCampo;
    private String mensagem;
}
