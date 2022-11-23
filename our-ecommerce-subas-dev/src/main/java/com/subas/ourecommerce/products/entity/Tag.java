package com.subas.ourecommerce.products.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Tag {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "tags" )
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "TagName = " + name + ")";
    }
}
