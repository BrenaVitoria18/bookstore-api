package com.vbs.bookstore.repository;

import com.vbs.bookstore.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Integer> {
}
