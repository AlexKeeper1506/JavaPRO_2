package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@NamedEntityGraph(
        name = "User.with-products",
        attributeNodes = {
                @NamedAttributeNode("products")
        }
)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Product> products;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
