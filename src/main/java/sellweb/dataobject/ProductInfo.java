package sellweb.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import org.hibernate.annotations.DynamicUpdate;
import sellweb.enums.PayStatusEnum;
import sellweb.enums.ProductStatusEnum;
import sellweb.utils.EnumUtil;


/**
 * The information of product
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    /**
     * 0 represents available, 1 represents unavailable
     */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
