package com.foxmonshop.backend.helper.error;

import com.foxmonshop.backend.helper.error.dto.ErrorResponseMessage;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
@NoArgsConstructor
public class ControllerExceptionHandler {
    public ResponseEntity<ErrorResponseMessage> globalResourceNotFoundExceptionHanlder(
        Exception e,
        WebRequest webRequest
    ) {
        ErrorResponseMessage errorResponseMessage = ErrorResponseMessage
            .builder()
            .message(e.getMessage())
            .description(webRequest.getDescription(false))
            .statusCode(HttpStatus.NOT_FOUND.value())
            .errorTimeStamp(LocalDateTime.now())
            .build();

        return new ResponseEntity<ErrorResponseMessage>(
          errorResponseMessage,
          HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(InternalError.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponseMessage> globalInternalExceptionHandler(
        Exception e,
        WebRequest webRequest
    ) {
        ErrorResponseMessage errorResponseMessage = ErrorResponseMessage
            .builder()
            .message(e.getMessage())
            .description(webRequest.getDescription(false))
            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .errorTimeStamp(LocalDateTime.now())
            .build();

        return new ResponseEntity<ErrorResponseMessage>(
            errorResponseMessage,
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
