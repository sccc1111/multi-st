package redis;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by songbo on 2018/7/24.
 */
@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1442134563392432775L;

    private Long id;

    private String name;

    private String password;

    private String email;

    private String mobile;

    private String status;

    private Date createTime;
}
