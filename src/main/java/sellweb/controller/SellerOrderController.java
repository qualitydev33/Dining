package sellweb.controller;

import lombok.extern.slf4j.Slf4j;
import sellweb.dto.OrderDTO;
import sellweb.enums.ResultEnum;
import sellweb.exception.SellException;
import sellweb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * The list of orders
     * @param page start from page(default = 1)
     * @param size the size of page
     * @param map
     * @return a view of the list of orders
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size,
                             Map<String, Object> map) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("order/list", map);
    }

    /**
     * Cancel order
     * @param orderId the id of the order to be canceled
     * @param map with the message and url to be redirected
     * @return the page with success or fail information
     */
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
        Map<String, Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (SellException e) {
            log.error("[Seller cancel order] has error{}", e.getMessage());
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success");
    }

    /**
     * Order detail
     * @param orderId the id of the order
     * @param map with the orderDTO to be displayed
     * or with the message and url to be redirected
     * @return the detail page
     * or the page with fail information
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
        Map<String, Object> map) {
        OrderDTO orderDTO;
        try {
            orderDTO = orderService.findOne(orderId);
        }catch (SellException e) {
            log.error("[Seller search order detail] has error{}", e.getMessage());
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail", map);
    }

    /**
     * Finish order
     * @param orderId the id of the order to be finished
     * @param map with the message and url to be redirected
     * @return the page with success or fail information
     */
    @GetMapping("/finish")
    public ModelAndView finished(@RequestParam("orderId") String orderId,
        Map<String, Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        } catch (SellException e) {
            log.error("[Seller finish order] has error{}", e.getMessage());
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success");
    }
}
