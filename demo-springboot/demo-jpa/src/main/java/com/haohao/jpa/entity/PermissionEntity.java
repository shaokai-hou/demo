package com.haohao.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author haohao
 * @date 2022年07月22日 16:21
 */
@Entity
@Table(name = "permission")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PermissionEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "permission_id")
    private Integer permissionId;

    @Column(name = "permission_name", nullable = false, length = 20)
    private String permissionName;
}
