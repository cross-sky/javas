package sherry.data.dto;

import sherry.data.pojo.CategoryDao;
import sherry.data.pojo.ProductDao;

import java.util.List;

/**
 * Created by Crossing on 2017-7-17.
 */
public class CategoryDto {
    private CategoryDao categoryDao;
    private List<ProductDao> productDaos;
    private int id;
    public List<ProductDao> getProductDaos() {
        return productDaos;
    }

    public void setProductDaos(List<ProductDao> productDaos) {
        this.productDaos = productDaos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
}
