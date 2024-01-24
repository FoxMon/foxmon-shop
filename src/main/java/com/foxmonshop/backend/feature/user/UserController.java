package com.foxmonshop.backend.feature.user;

import com.foxmonshop.backend.feature.user.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserDto.Response> createUserRequest(
        @RequestBody final UserDto.CreateRequest dto
    ) {
        return ResponseEntity.ok().body(
            new UserDto.Response(this.userService.createUserRequestService(dto))
        );
    }
}
