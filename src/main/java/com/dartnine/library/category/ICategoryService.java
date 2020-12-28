package com.dartnine.library.category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category getCategoryByCode(String code);
}
