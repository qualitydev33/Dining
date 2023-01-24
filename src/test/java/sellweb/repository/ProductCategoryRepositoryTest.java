package sellweb.repository;

import org.springframework.data.domain.Example;
import sellweb.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)

@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory model = new ProductCategory();
        model.setCategoryId(1);
        Example<ProductCategory> orderMasterExample = Example.of(model);
        ProductCategory productCategory = repository.findOne(orderMasterExample).orElse(null);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void saveTest() {
        ProductCategory model = new ProductCategory();
        model.setCategoryId(5);
        Example<ProductCategory> orderMasterExample = Example.of(model);
        ProductCategory productCategory = repository.findOne(orderMasterExample).orElse(null);
        productCategory.setCategoryType(5);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(null, result);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(1, 5);

        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        System.out.println(result);
        Assert.assertNotEquals(0, result.size());
    }
}