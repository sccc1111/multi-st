package mybaits.service.impl;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import mybaits.mapper.UserMapper;
import mybaits.model.UserDto;
import mybaits.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songbo on 2018/7/25.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto save(UserDto user) {
        userMapper.insertUseGeneratedKeys(user);
        return user;
    }

    @Override
    public List<UserDto> saveList(List<UserDto> userList) {
        userMapper.insertList(userList);
        return userList;
    }

    @Override
    public UserDto update(UserDto user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i > 0) {
            log.info("【UserDtoService】更新成功：{}条目", i);
        } else {
            log.error("【UserDtoService】更新失败：{}", user);
        }
        return userMapper.selectByPrimaryKey(user.getId());
    }

    @Override
    public Integer delete(UserDto user) {
        return userMapper.deleteByPrimaryKey(user);
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserDto findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<UserDto> findUserDtoByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAll();
    }
}
