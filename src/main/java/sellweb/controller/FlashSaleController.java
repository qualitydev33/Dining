package sellweb.controller;

import sellweb.service.FlashSaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flash")
@Slf4j
public class FlashSaleController {

    @Autowired
    private FlashSaleService flashSaleService;

    /**
     * Search the product info for flash sale
     * @param productId
     * @return
     */
    @GetMapping("/query/{productId}")
    public String query(@PathVariable String productId)throws Exception
    {
        return flashSaleService.queryFlashSaleProductInfo(productId);
    }


    /**
     * Get Flash sale's information for the product
     * @param productId
     * @return the sale information
     * @throws Exception
     */
    @GetMapping("/order/{productId}")
    public String flashSale(@PathVariable String productId)throws Exception
    {
        log.info("@Flash sale request, productId:" + productId);
        flashSaleService.orderProductMockDiffUser(productId);
        return flashSaleService.queryFlashSaleProductInfo(productId);
    }
}
