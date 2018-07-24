package jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by songbo on 2018/7/24.
 */
public interface JpaUserRepository extends JpaRepository<SysUser, Long> {

    @Query("select id,name,password,email,mobile,status from sys_user u where u.name like :name")
    SysUser findSysUser(@Param("name") String name);

    SysUser findSysUserByName(String name);

    List<SysUser> findSysUsersByIdIn(List<Long> ids);
}
