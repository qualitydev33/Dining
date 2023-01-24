package sellweb.service;


import sellweb.dto.OrderDTO;


public interface BuyerService {

    //Find an order with correct openid
    OrderDTO findLegalOrder(String openid, String orderId);

    //Cancel an order with correct openid
    OrderDTO cancelLegalOrder(String openid, String orderId);
}
