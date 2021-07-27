package com.example.jpatest.model;

import javax.persistence.*;

@Entity
@Table(name = "sub_categoria")
public class SubCategoria {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_CATEGORIA"), nullable=true)    
    private Categoria categoria;

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Column(name = "title")
	private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}