package sellweb.service;

public interface FlashSaleService {

    /**
     * Search the product information of flash sale
     * @param productId the id of product
     * @return
     */
    String queryFlashSaleProductInfo(String productId);

    /**
     * Mock queries from different users
     * @param productId the id of product
     */
    void orderProductMockDiffUser(String productId);

}
