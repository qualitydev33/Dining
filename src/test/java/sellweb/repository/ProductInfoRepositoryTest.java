package sellweb.repository;

import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import sellweb.dataobject.ProductInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    @Transactional
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("Basil tomato pasta");
        productInfo.setProductPrice(new BigDecimal("15.99"));
        productInfo.setProductStock(10);
        productInfo.setProductDescription("very delicious pasta");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfoList.size());
    }

}