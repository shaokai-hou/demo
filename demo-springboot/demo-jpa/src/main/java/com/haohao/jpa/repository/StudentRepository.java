package com.haohao.jpa.repository;

import com.haohao.jpa.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author haohao
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    /**
     * 通过名称获取学生
     *
     * @param name 名称
     * @return 学生对象
     */
    StudentEntity findByName(String name);

    /**
     * 通过年龄查询学生
     *
     * @param age 年龄
     * @return 学生对象
     */
    @Query(value = "select * from student where age = ?1 ", nativeQuery = true)
    StudentEntity findStudentByAge(int age);

    /**
     * 通过年龄删除学生
     *
     * @param age 年龄
     */
    @Modifying
    @Query(value = "delete from student where age =?1", nativeQuery = true)
    void deleteStudentByAge(int age);
}
