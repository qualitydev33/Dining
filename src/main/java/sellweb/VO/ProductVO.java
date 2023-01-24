package sellweb.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

import java.util.List;


/**
 * The view object of product.
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -2162491663499655022L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
