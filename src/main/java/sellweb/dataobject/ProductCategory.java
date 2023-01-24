package sellweb.dataobject;

import java.util.Date;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * The type Product category.
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    /**
     * Instantiates a new Product category.
     */
    public ProductCategory() {
    }

    /**
     * Instantiates a new Product category.
     *
     * @param categoryName the category name
     * @param categoryType the category type
     */
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
