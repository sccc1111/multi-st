package mybaits.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by songbo on 2018/7/24.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="sys_user")
public class UserDto {
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
