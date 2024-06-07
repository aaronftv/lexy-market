package com.aaron.merch_aaron.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorias")
public class CategoryEnt {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Integer categoryId;

    @Column(name="descripcion")
    private String description;

    @Column(name="estado")
    private Boolean status;

    @OneToMany(mappedBy = "category")
    private List<ProductEnt> products;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<ProductEnt> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEnt> products) {
        this.products = products;
    }
}
