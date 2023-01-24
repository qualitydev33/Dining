package sellweb.service;

import sellweb.dataobject.ProductCategory;

import java.util.List;

/**
 * The interface Category service.
 */
public interface CategoryService {

    /**
     * Find one product category.
     *
     * @param categoryId the category id
     * @return the product category
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<ProductCategory> findAll();

    /**
     * Find by category type in list.
     *
     * @param categoryTypeList the category type list
     * @return the list
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * Save product category.
     *
     * @param productCategory the product category
     * @return the product category
     */
    ProductCategory save(ProductCategory productCategory);
}
