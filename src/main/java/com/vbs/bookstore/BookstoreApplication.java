package com.vbs.bookstore;

import com.vbs.bookstore.model.CategoriaModel;
import com.vbs.bookstore.model.LivroModel;
import com.vbs.bookstore.repository.CategoriaRepository;
import com.vbs.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication {



	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}


}
