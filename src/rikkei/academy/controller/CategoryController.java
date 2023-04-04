package rikkei.academy.controller;

import rikkei.academy.model.Category;
import rikkei.academy.service.CategoryServiceIMPL;
import rikkei.academy.service.ICategoryService;

import java.util.List;

public class CategoryController {
    public ICategoryService categoryService = new CategoryServiceIMPL();
    public List<Category> getListCategory(){
        return categoryService.findAll();
    }
    public void createCategoryToDB(Category category){
        categoryService.save(category);
    }
    public void updateCategory(Category category){
        categoryService.save(category);
    }
    public Category detailCategory(int id){
      return categoryService.findById(id);
    }
}
