package com.thoughtworks.capacity.gtb.mvc.api;

import com.thoughtworks.capacity.gtb.mvc.domain.Constants;
import com.thoughtworks.capacity.gtb.mvc.domain.UserInfo;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void userRegister(@RequestBody @Valid UserInfo userInfo) {
        this.userService.userRegister(userInfo);
    }

    @PostMapping("/login")
    public UserInfo userLogin(
            @RequestParam("username")
            @Size(min = Constants.USERNAME_MIN_LENGTH, max = Constants.USERNAME_MAX_LENGTH, message = Constants.USERNAME_LENGTH_ERROR)
            @Pattern(regexp = "[0-9A-Za-z_]*", message = Constants.USERNAME_CONTENT_ERROR) String username,
            @RequestParam("password")
            @Size(min = Constants.PASSWORD_MIN_LENGTH, max = Constants.PASSWORD_MAX_LENGTH, message = Constants.PASSWORD_LENGTH_ERROR)
            String password ) {
        return this.userService.userLogin(username, password);
    }

}
