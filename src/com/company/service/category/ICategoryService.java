package com.company.service.category;

import com.company.model.Category;
import com.company.service.IServiceGeneric;

import java.util.List;

public interface ICategoryService extends IServiceGeneric<Category> {
    List<Category> findByUser();
}
