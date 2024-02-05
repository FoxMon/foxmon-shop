package com.foxmonshop.backend.feature.user.dao;

import com.foxmonshop.backend.feature.user.domain.User;
import com.foxmonshop.backend.feature.user.dto.UserDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User createUserRequestService(UserDto.CreateRequest dto) {
        final User user = dto.toEntity(passwordEncoder);

        return this.userRepository.save(user);
    }

    public List<UserDto.Response> getAllUserRequestService() {
        List<User> users = this.userRepository.findAll();

         return users
             .stream()
             .map(UserDto.Response::new)
             .toList();
    }
}
