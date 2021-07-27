package com.example.jpatest.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "sub_categoria")
public class SubCategoria{
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // @JoinColumn(foreignKey = @ForeignKey(name = "FK_CATEGORIA"), nullable=true)    
    // @JsonBackReference   
    // @JsonIgnore
    // @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    // @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne()
    @JoinColumn(name = "categoria_id", nullable=false) 
    private Categoria categoria;

    @JsonBackReference
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