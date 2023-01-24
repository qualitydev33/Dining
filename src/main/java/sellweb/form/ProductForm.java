package sellweb.form;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductForm {
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer categoryType;
}
