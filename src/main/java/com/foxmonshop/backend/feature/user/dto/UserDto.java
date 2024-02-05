package com.foxmonshop.backend.feature.user.dto;

import com.foxmonshop.backend.common.BaseEntity;
import com.foxmonshop.backend.feature.user.domain.Address;
import com.foxmonshop.backend.feature.user.domain.User;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UserDto extends BaseEntity {

    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter
    public static class CreateRequest {
        private String name;

        private String password;

        private int age;

        private String introduce;

        private String birth;

        private Address address;

        public User toEntity(PasswordEncoder passwordEncoder) {
            return User
                .builder()
                .name(this.name)
                .password(passwordEncoder.encode(this.password))
                .age(this.age)
                .introduce(this.introduce)
                .birth(this.birth)
                .address(this.address)
                .build();
        }
    }

    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter
    public static class Response {
        private User user;

        public Response(final User user) {
            this.user = user;
        }
    }
}
