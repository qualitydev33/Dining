package sellweb.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import sellweb.enums.OrderStatusEnum;
import sellweb.enums.PayStatusEnum;


/**
 * The information of Order master.
 */
@Entity
//Lombok plugin to produce methods(getters,
// setters and etc.) by default
@Data
//update time dynamically
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    /**
     * The status of order, new order by default.
     */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**
     * The status of payment, unpaid by default.
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;
}
