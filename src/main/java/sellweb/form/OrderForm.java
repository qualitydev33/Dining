package sellweb.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class OrderForm {

    @NotEmpty(message = "Buyer name is required")
    private String name;

    @NotEmpty(message = "Phone number is required")
    private String phone;

    @NotEmpty(message = "Address is required")
    private String address;

    @NotEmpty(message = "OpenId is required")
    private String openid;


    @NotEmpty(message = "Order items cannot be empty")
    private String items;
}
