package redis;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by songbo on 2018/7/25.
 */
@Slf4j
@Component
public class UserDao {
    private static List<User> users = Lists.newArrayList();
    private static AtomicLong SEQ = new AtomicLong(0L);

    public User save() {
        log.info("save.....");
        User user = new User();
        user.setId(SEQ.get());
        user.setName("xkcoding" + SEQ.get());
        user.setCreateTime(new Date());
        users.add(user);
        SEQ.getAndIncrement();
        return user;
    }

    public User update(Long id) {
        log.info("update.....");
        for (User user1 : users) {
            if (user1.getId().equals(id)) {
                user1.setName("修改后的名字");
                return user1;
            }
        }
        return null;
    }

    public User delete(Long id) {
        log.info("delete.....");
        User user = find(id);
        users.remove(user);
        return user;
    }

    public List<User> find() {
        log.info("findAll.....");
        return users;
    }

    public User find(String name) {
        log.info("findByName.....");
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public User find(Long id) {
        log.info("findById.....");
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
