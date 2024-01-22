package com.foxmonshop.backend.helper.error.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseMessage {
    private String message;

    private String description;

    private int statusCode;

    private LocalDateTime errorTimeStamp;
}
