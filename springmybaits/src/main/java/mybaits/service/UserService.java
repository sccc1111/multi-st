package mybaits.service;

import mybaits.model.UserDto;

import java.util.List;

/**
 * Created by songbo on 2018/7/25.
 */
public interface UserService {
    UserDto save(UserDto user);

    List<UserDto> saveList(List<UserDto> userList);

    UserDto update(UserDto user);

    Integer delete(UserDto user);

    UserDto findById(Long id);

    UserDto findByName(String name);

    List<UserDto> findAll();

    List<UserDto> findUserDtoByPage(Integer pageNum, Integer pageSize);
}
