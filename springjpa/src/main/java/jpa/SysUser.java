package jpa;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by songbo on 2018/7/24.
 */
@Entity
@Getter
@Setter
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "status")
    private String status;

    @Column(name = "create_time")
    private Date createTime;
}
