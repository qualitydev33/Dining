package sellweb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import sellweb.dataobject.OrderDetail;
import sellweb.enums.OrderStatusEnum;
import sellweb.enums.PayStatusEnum;
import sellweb.utils.EnumUtil;
import sellweb.utils.serializer.DateToLongSerializer;

@Data
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    /**
     * The status of order
     */
    private Integer orderStatus;

    /**
     * The status of payment
     */
    private Integer payStatus;

    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = DateToLongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
