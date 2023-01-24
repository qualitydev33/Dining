package sellweb.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import sellweb.dataobject.OrderDetail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("000000001");
        orderDetail.setOrderId("1234567");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("123457");
        orderDetail.setProductName("potato pizza");
        orderDetail.setProductPrice(new BigDecimal(7.99));
        orderDetail.setProductQuantity(3);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repository.findByOrderId("1234567");
        Assert.assertNotEquals(0, orderDetailList.size());
    }

}