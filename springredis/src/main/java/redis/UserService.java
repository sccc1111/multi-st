package redis;

import java.util.List;

/**
 * Created by songbo on 2018/7/25.
 */
public interface UserService {
    User save();

    User update(Long id);

    User delete(Long id);

    List<User> find();

    User find(Long id);

    User find(String name);
}
