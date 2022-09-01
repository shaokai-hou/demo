package com.haohao.jpa.repository;

import com.haohao.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户
 *
 * @author haohao
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
