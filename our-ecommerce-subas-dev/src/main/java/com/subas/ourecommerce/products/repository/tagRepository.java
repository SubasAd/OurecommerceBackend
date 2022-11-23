package com.subas.ourecommerce.products.repository;

import com.subas.ourecommerce.products.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tagRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String tag);
}
