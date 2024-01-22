package com.foxmonshop.backend.feature.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "user")
public class User {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int age;

    @Column
    private String introduce;

    @Column
    private String birth;

    @Column
    private String address;
}
