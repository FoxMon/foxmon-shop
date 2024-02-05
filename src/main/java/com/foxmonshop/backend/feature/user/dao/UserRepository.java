package com.foxmonshop.backend.feature.user.dao;

import com.foxmonshop.backend.feature.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
