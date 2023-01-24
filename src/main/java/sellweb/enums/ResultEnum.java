package sellweb.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PARAM_ERROR(1, "Wrong params"),

    PRODUCT_NOT_EXIST(10, "The product doesn't exist"),

    PRODUCT_STOCK_ERROR(11, "The stock of product is incorrect"),

    ORDER_NOT_EXIST(12, "The order doesn't exist"),

    ORDERDETAIL_NOT_EXIST(13, "The order detail doesn't exist"),

    ORDER_STATUS_ERROR(14, "The order status is incorrect"),

    ORDER_UPDATE_FAIL(15, "The order cannot be updated"),

    ORDER_DETAIL_EMPTY(16, "The order detail is empty"),

    ORDER_PAY_STATUS_ERROR(17, "The payment status is incorrect"),

    CART_EMPTY(18, "Shopping cart is empty"),

    ORDER_OWNER_ERROR(19, "This order and buyer don't match"),

    ORDER_CANCEL_SUCCESS(22, "Canceled successfully"),

    ORDER_FINISH_SUCCESS(23, "Finished successfully"),

    PRODUCT_STATUS_ERROR(24, "The product status is incorrect"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
