package com.haohao.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author haohao
 * @date 2022年07月22日 16:24
 */
@Entity
@Table(name = "user_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetailEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "user_detail_id")
    private Integer userDetailId;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

}
