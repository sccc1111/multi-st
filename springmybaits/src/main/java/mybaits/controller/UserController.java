package mybaits.controller;

import com.google.common.collect.Lists;
import mybaits.model.UserDto;
import mybaits.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by songbo on 2018/7/25.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/save")
    public UserDto save() {
        UserDto UserDto = new UserDto();
        UserDto.setName("xkcoding");
        UserDto.setMobile("18600000000");
        UserDto.setCreateTime(new Date());
        return userService.save(UserDto);
    }

    @GetMapping("/saveList")
    public List<UserDto> saveList() {
        ArrayList<UserDto> userList = Lists.newArrayList();
        for (int i = 0; i < 20; i++) {
            UserDto UserDto = new UserDto();
            UserDto.setName("xkcoding" + i);
            UserDto.setMobile("186111111" + ((i < 10) ? ("0" + i) : i));
            UserDto.setCreateTime(new Date());
            userList.add(UserDto);
        }
        return userService.saveList(userList);
    }

    @GetMapping("/update")
    public UserDto update() {
        UserDto UserDto = new UserDto();
        UserDto.setId(2L);
        UserDto.setName(" 修改后的名字 ");
        userService.update(UserDto);

        return userService.update(UserDto);
    }

    @GetMapping("/delete")
    public UserDto delete() {
        UserDto UserDto = new UserDto();
        UserDto.setId(1L);
        userService.delete(UserDto);

        return userService.findById(1L);
    }

    @GetMapping("/find/{id}")
    public UserDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/find")
    public UserDto findByName(@RequestParam String name) {
        return userService.findByName(name);
    }

    @GetMapping({"", "/"})
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/page")
    public List<UserDto> findByPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        return userService.findUserDtoByPage(pageNum, pageSize);
    }
}
