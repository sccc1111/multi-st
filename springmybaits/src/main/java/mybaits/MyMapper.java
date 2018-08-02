package mybaits;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by songbo on 2018/7/25.
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
