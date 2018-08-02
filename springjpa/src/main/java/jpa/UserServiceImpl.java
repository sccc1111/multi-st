package jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songbo on 2018/7/24.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUser findById(Long id) {
        return sysUserRepository.findOne(id);
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserRepository.findAll();
    }

    @Override
    public SysUser insert(SysUser user) {
        return sysUserRepository.save(user);
    }

    @Override
    public SysUser update(SysUser user) {
        return sysUserRepository.save(user);
    }

    @Override
    public void delete(SysUser user) {
        sysUserRepository.delete(user);
    }

    @Override
    public List<SysUser> insertList(List<SysUser> userList) {
        return sysUserRepository.save(userList);
    }

    @Override
    public Page<SysUser> findByPage(Pageable pageable) {
        return sysUserRepository.findAll(pageable);
    }

    @Override
    public List<SysUser> findSysUserByName(String name) {
        return sysUserRepository.findSysUserByName(name);
    }
}
