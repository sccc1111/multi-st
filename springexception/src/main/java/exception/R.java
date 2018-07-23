package exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by songbo on 2018/7/23.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {
    private Integer code;
    private String message;
    private T data;

    public R(Status status) {
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public static R success(Integer code, String message, Object data) {
        return new R(code, message, data);
    }

    public static R success() {
        return new R(Status.OK);
    }

    public static R success(String message) {
        return success(message, null);
    }

    public static R success(String message, Object data) {
        return success(Code.SUCCESS.getCode(), message, data);
    }

    public static R error(Integer code, String message, Object data) {
        return new R(code, message, data);
    }

    public static R error(Integer code, String message) {
        return error(code, message, null);
    }

    public static R error(JsonException exception) {
        return error(exception.getCode(), exception.getMessage());
    }
}
