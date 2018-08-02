package jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by songbo on 2018/7/24.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    @Query("SELECT id,name,createTime from SysUser where name like CONCAT('%',:name,'%')")
    List<SysUser> findSysUserByName(@Param(value="name")String name);



}
