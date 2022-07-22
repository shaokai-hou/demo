package com.haohao.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author haohao
 * @date 2022年07月22日 11:49
 */
@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentEntity implements Serializable {

    /**
     * 学生id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    /**
     * 学生名称
     */
    @Column(name = "name", length = 20)
    private String name;

    /**
     * 学生年纪
     */
    @Column(name = "age")
    private Integer age;

}
