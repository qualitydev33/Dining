package sellweb.VO;

import java.io.Serializable;
import lombok.Data;


/**
 * The view object of result .
 *
 * @param <T> the type of data
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 4545370322590323488L;
    /**
     * The code of status
     */
    private Integer code;


    /**
     * The message
     */
    private String msg;


    /**
     * The data
     */
    private T data;
}
