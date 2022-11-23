package com.subas.ourecommerce.products.service.impl;

import com.subas.ourecommerce.products.entity.Tag;
import com.subas.ourecommerce.products.repository.tagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class tagService {
    final
    tagRepository repo;

    public tagService(tagRepository repo) {
        this.repo = repo;
    }

    Tag findTag(String name) {
      return repo.findByName(name);
    }
}
