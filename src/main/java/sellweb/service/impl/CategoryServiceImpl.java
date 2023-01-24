package sellweb.service.impl;

import org.springframework.data.domain.Example;
import sellweb.dataobject.ProductCategory;
import sellweb.repository.ProductCategoryRepository;
import sellweb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        ProductCategory model = new ProductCategory();
        model.setCategoryId(categoryId);
        Example<ProductCategory> orderMasterExample = Example.of(model);
        return repository.findOne(orderMasterExample).orElse(null);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
