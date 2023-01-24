package sellweb.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0, "Available"),
    DOWN(1, "Unavailable");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
