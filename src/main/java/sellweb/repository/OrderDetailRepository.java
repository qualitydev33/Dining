package sellweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import sellweb.dataobject.OrderDetail;


public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
