package com.example.jpatest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.jpatest.model.Categoria;
import com.example.jpatest.projections.CategoriaCustom;
import java.util.Optional;
import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query(value = "SELECT * FROM categoria ORDER BY id DESC;", nativeQuery = true)
    List<Categoria> findCategorias();

    @Query(value = "SELECT * FROM list_categorias();", nativeQuery = true)
    List<CategoriaCustom> findCategoriasObject();

    @Query(value = "SELECT * FROM get_categoria(:id);", nativeQuery = true)
    Optional<CategoriaCustom> findCategoriaById(@Param("id") Integer id);
}