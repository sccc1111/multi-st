package exception;


import lombok.Getter;

/**
 * Created by songbo on 2018/7/23.
 */

public enum Status {
    OK(200, "成功"), UNKNOW_ERROR(-1, "未知错误");
    @Getter
    private Integer code;
    @Getter
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
