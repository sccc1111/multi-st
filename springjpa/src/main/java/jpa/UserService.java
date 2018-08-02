package jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by songbo on 2018/7/24.
 */
public interface UserService {
    SysUser findById(Long id);

    List<SysUser> findAll();

    SysUser insert(SysUser user);

    SysUser update(SysUser user);

    void delete(SysUser user);

    List<SysUser> insertList(List<SysUser> userList);

    List<SysUser> findSysUserByName(String name);

    Page<SysUser> findByPage(Pageable pageable);
}
