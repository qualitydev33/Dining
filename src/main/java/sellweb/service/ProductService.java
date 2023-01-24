package sellweb.service;

import sellweb.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import sellweb.dto.CartDTO;

public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * find all the available products
     * @return a list of the available products
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //add stock
    void increaseStock(List<CartDTO> cartDTOList);

    //reduce stock
    void decreaseStock(List<CartDTO> cartDTOList);

    ProductInfo onSale(String productId);

    ProductInfo offSale(String productId);
}
