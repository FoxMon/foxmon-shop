package com.foxmonshop.backend.feature.user;

import com.foxmonshop.backend.feature.user.dto.UserDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User createUserRequestService(UserDto.CreateRequest dto) {
        final User user = dto.toEntity();

        return this.userRepository.save(user);
    }
}
