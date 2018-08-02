package redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songbo on 2018/7/25.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User save() {
        return userDao.save();
    }

    @Override
    public User update(Long id) {
        return userDao.update(id);
    }

    @Override
    public User delete(Long id) {
        return userDao.delete(id);
    }

    @Override
    public List<User> find() {
        return userDao.find();
    }

    @Override
    public User find(Long id) {
        return userDao.find(id);
    }

    @Override
    public User find(String name) {
        return userDao.find(name);
    }
}
