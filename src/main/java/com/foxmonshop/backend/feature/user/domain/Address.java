package com.foxmonshop.backend.feature.user.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
    private String city;

    private String detail;

    private String zip;

    @Builder
    public Address(String city, String detail, String zip) {
        this.city = city;

        this.detail = detail;

        this.zip = zip;
    }
}
