package com.example.jpatest.model;
// import java.util.HashSet;
// import java.util.Set;
import java.util.List;
import javax.persistence.*;

@Entity(name = "categoria")
@Table(name = "categoria")
public class Categoria {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "title")
	private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<SubCategoria> subCategorias;

    // public List<SubCategoria> getSubCategorias() {
    //     return this.subCategorias;
    // }

    // public void setSubCategorias(List<SubCategoria> subCategorias) {
    //     this.subCategorias = subCategorias;
    // }

}
