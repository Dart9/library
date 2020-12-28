package com.dartnine.library.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    ICategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        List<Category> categories = categoryDao.findAll();
        System.out.println(categories.size());
        return categories;
    }

    @Override public Category getCategoryByCode(String code) {
        return categoryDao.getCategoryByCode(code);
    }
}
