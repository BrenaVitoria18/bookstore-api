package com.vbs.bookstore.controller.exception;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StandardError {
    private Long timestamp;
    private Integer status;
    private String error;


}
