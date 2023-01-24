package sellweb.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sellweb.dto.OrderDTO;

public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);

    OrderDTO findOne(String orderId);

    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    Page<OrderDTO> findList(Pageable pageable);

    OrderDTO cancel(OrderDTO orderDTO);

    OrderDTO finish(OrderDTO orderDTO);

    OrderDTO pay(OrderDTO orderDTO);
}
