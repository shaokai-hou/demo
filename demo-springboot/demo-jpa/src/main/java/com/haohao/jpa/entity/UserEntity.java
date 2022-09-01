package com.haohao.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author haohao
 * @date 2022年07月22日 16:14
 */
@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_detail_id", insertable = false, updatable = false)
    private Integer userDetailId;

    @OneToOne
    @JoinColumn(name = "user_detail_id", referencedColumnName = "user_detail_id")
    private UserDetailEntity userDetail;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

}
