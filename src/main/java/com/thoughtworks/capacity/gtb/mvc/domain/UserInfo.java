package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Integer id;
    @NotNull(message = "username must not be null")
    @NotBlank(message = "username can not be empty")
    @Length(min = 3, max = 10, message = "username length must between 3 and 12")
    private String username;
    @NotNull(message = "password must not be null")
    @NotBlank(message = "password can not be empty")
    @Length(min = 5, max = 12, message = "password length must between 5 and 12")
    private String password;
    @Email(message = "email must has right format")
    private String email;
}
