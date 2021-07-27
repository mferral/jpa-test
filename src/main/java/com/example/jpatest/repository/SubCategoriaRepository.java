package com.example.jpatest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpatest.model.SubCategoria;

@Repository
public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Long> {

}