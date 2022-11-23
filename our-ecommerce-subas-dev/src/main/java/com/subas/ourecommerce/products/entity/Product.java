package com.subas.ourecommerce.products.entity;

import com.subas.ourecommerce.products.repository.ProductRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
//import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.*;


@RequiredArgsConstructor
@Entity
public class Product {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private String Name;
    private boolean isDeleted;
    private short onStock;


    private String pic  ;
    private String Description;


        @ManyToMany(fetch = FetchType.LAZY , cascade ={ CascadeType.PERSIST ,CascadeType.MERGE})
        private Set<Tag> tags = new HashSet<>();




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public short getOnStock() {
        return onStock;
    }

    public void setOnStock(short onStock) {
        this.onStock = onStock;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "Name = " + Name + ")";
    }
}
