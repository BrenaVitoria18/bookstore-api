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
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CategoriaModel categoriaModel = new CategoriaModel(null, "Informática", "Livros de TI");
		LivroModel livroModel = new LivroModel(null, "Clean code", "Robert Martin", "Lorem ipsum", categoriaModel);
		categoriaModel.getLivros().addAll(Arrays.asList(livroModel));

		this.categoriaRepository.saveAll(Arrays.asList(categoriaModel));
		this.livroRepository.saveAll(Arrays.asList(livroModel));

	}
}
