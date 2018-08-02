package jpa;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by songbo on 2018/7/24.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @GetMapping("/{id}")
    public SysUser findById(@PathVariable Long id) {
        return userServiceImpl.findById(id);
    }

    @GetMapping({"", "/", "/index"})
    public List<SysUser> findAll() {
        return userServiceImpl.findAll();
    }

    @GetMapping("/save")
    public SysUser insert() {
        SysUser user = new SysUser();
        user.setName("xkcoding");
        user.setCreateTime(new Date());
        return userServiceImpl.insert(user);
    }

    @GetMapping("/update")
    public SysUser update() {
        SysUser user = userServiceImpl.findById(1L);
        user.setName("修改后的姓名");
        return userServiceImpl.update(user);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if (id == null) {
            return "Id 不能为空";
        }
        SysUser SysUser = userServiceImpl.findById(id.longValue());
        if (SysUser == null) {
            return "用户不存在";
        }
        userServiceImpl.delete(SysUser);
        return SysUser.getName() + "删除成功";
    }

    @GetMapping("/saveList")
    public List<SysUser> insertList() {
        List<SysUser> userList = Lists.newArrayList();
        for (int i = 0; i < 20; i++) {
            SysUser SysUser = new SysUser();
            SysUser.setName("xkcoding" + i);
            SysUser.setCreateTime(new Date());
            userList.add(SysUser);
        }
        return userServiceImpl.insertList(userList);
    }
    @GetMapping("/page")
    public Page<SysUser> findByPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageRequest pageRequest = new PageRequest(pageNum - 1, pageSize);
        return userServiceImpl.findByPage(pageRequest);
    }

    @GetMapping("/name/{name}")
    public List<SysUser> insertList(@PathVariable String name) {
        return userServiceImpl.findSysUserByName(name);
    }
}
