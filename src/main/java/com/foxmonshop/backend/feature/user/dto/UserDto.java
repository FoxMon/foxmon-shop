package com.foxmonshop.backend.feature.user.dto;

import com.foxmonshop.backend.common.BaseEntity;
import com.foxmonshop.backend.feature.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserDto extends BaseEntity {
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter
    public static class CreateRequest {
        private String name;

        private String password;

        private int age;

        private String introduce;

        private String birth;

        private String address;

        @Builder
        public CreateRequest(
            String name, String password, int age,
            String introduce, String birth, String address
        ) {
            this.name = name;
            this.password = password;
            this.age = age;
            this.introduce = introduce;
            this.birth = birth;
            this.address = address;
        }

        public User toEntity() {
            return User
                .builder()
                .name(this.name)
                .password(this.password)
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
        private User response;

        public Response(final User user) {
            this.response = user;
        }
    }
}
