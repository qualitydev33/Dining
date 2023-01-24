package sellweb.service.impl;

import sellweb.exception.SellException;
import sellweb.service.RedisLock;
import sellweb.service.FlashSaleService;
import sellweb.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class FlashSaleServiceImpl implements FlashSaleService {

    private static final int TIMEOUT = 10 * 1000;

    @Autowired
    private RedisLock redisLock;

    /**
     * Flash sale for Basil tomato pasta
     * Total amount: 100
     */
    static Map<String,Integer> products;
    static Map<String,Integer> stock;
    static Map<String,String> orders;
    static
    {
        /**
         * Mock multiple tables:
         * Product info table, stock table, flash sale order table
         */
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("123456", 1000);
        stock.put("123456", 1000);
    }

    private String queryMap(String productId)
    {
        return "Flash sale for Basil tomato pasta, "
                + "total amount: " + products.get(productId)
                + ". Left: " + stock.get(productId)+" bowls. "
                + orders.size() +" orders have been placed." ;
    }

    @Override
    public String queryFlashSaleProductInfo(String productId) {
        return this.queryMap(productId);
    }

    @Override
    public void orderProductMockDiffUser(String productId)
    {
        //Add lock
        long time = System.currentTimeMillis() + TIMEOUT;
        if (!redisLock.lock(productId, String.valueOf(time))) {
            throw new SellException(101, "Order cannot be placed, try it later.");
        }

        //1.search for the stock of this product, stop until zero.
        int stockNum = stock.get(productId);
        if(stockNum == 0) {
            throw new SellException(100,"This flash sale ended");
        }else {

            //2.Place order(Mock different open id for different user)
            orders.put(KeyUtil.genUniqueKey(),productId);

            //3.Reduce stock
            stockNum = stockNum - 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stock.put(productId,stockNum);
        }

        //Unlock
        redisLock.unlock(productId, String.valueOf(time));
    }
}
