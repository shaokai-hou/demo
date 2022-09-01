package com.haohao.jpa.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author haohao
 * @date 2022年07月22日 16:20
 */
@Entity
@Table(name = "role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleEntity {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name", nullable = false, length = 20)
    private String roleName;
}
