package com.example.jwt_tutorial.Repository;

import com.example.jwt_tutorial.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    // 쿼리가 수행이될떄 Lazy조회가 아니고 Eager 조회로 auhorities정보를 가져오게 됩니다.
    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesByUsername(String username);
}
