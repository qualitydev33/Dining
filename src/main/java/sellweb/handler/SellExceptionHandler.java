package sellweb.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import sellweb.VO.ResultVO;
import sellweb.exception.SellException;
import sellweb.utils.ResultVOUtil;

@ControllerAdvice
public class SellExceptionHandler {

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellExceptionHandler(SellException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }
}
