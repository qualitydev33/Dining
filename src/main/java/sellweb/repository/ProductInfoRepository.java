package sellweb.repository;

import sellweb.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Product info repository.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * Find products by product status.
     *
     * @param productStatus the product status
     * @return the list of products
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
