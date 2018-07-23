package exception;

import lombok.Getter;

/**
 * Created by songbo on 2018/7/23.
 */
@Getter
public enum Code {
    SUCCESS(200);
    private Integer code;

    Code(Integer code) {
        this.code = code;
    }
}
