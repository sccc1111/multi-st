package exception;

import lombok.Getter;

/**
 * Created by songbo on 2018/7/23.
 */
@Getter
public class JsonException extends RuntimeException{
    public Integer code;

    public JsonException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
