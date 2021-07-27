package com.example.jpatest.projections;

import com.example.jpatest.model.Categoria;
import com.example.jpatest.model.SubCategoria;
// import org.springframework.data.rest.core.config.Projection;

import org.springframework.beans.factory.annotation.Value;

// @Projection(
//   name = "customSubCategoria", 
//   types = { SubCategoria.class }) 
public interface SubCategoriaCustom {
    String getTitle();

    Categoria getCategoria();

    @Value("#{target.id} #{target.title}")
    String getFullName();

    interface Categoria {
        String getTitle();
    }
}
