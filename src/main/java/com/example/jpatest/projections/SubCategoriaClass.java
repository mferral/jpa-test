package com.example.jpatest.projections;
// import com.example.jpatest.model.Categoria;

public class SubCategoriaClass{
	private long id;
    private String title;
    private String custom;

    public String getCustom() {
        return this.custom;
    }

    public SubCategoriaClass(Long id, String title) {
        this.id = id;
        this.title = title;
    }


    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }
    // @ManyToOne()
    // private Categoria categoria;

    // public Categoria getCategoria() {
    //     return this.categoria;
    // }
}