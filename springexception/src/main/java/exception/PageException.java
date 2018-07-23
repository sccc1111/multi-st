package exception;

import lombok.Getter;

/**
 * Created by songbo on 2018/7/23.
 */
@Getter
public class PageException extends RuntimeException {
    public Integer code;

    public PageException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}