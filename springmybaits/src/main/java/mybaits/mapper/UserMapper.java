package mybaits.mapper;

import mybaits.MyMapper;
import mybaits.model.UserDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by songbo on 2018/7/25.
 */
@Component(value = "userMapper")
public interface UserMapper extends MyMapper<UserDto> {
    UserDto findByName(@Param("name") String name);
}
