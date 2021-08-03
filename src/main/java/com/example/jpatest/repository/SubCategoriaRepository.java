package com.example.jpatest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import java.io.Serializable;
import java.util.List;

import com.example.jpatest.projections.SubCategoriaCustom;
import com.example.jpatest.models.SubCategoria;
import com.example.jpatest.projections.SubCategoriaClass;

@Repository
public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Long> {
    // List<SubCategoria> findByTitle(String title);
    List<SubCategoriaCustom> findAllProjectedBy();
    List<SubCategoriaClass> findAllBy();
}