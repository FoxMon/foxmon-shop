package com.foxmonshop.backend.feature.user;

import com.foxmonshop.backend.feature.user.dao.UserService;
import com.foxmonshop.backend.feature.user.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/users")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<UserDto.Response> createUserRequest(
        @RequestBody final UserDto.CreateRequest dto
    ) {
        return ResponseEntity.ok().body(
            new UserDto.Response(this.userService.createUserRequestService(dto))
        );
    }

    @GetMapping("/users")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<UserDto.Response>> getAllUserRequest() {
        return ResponseEntity.ok().body(this.userService.getAllUserRequestService());
    }
}
