package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Integer id;
    @NotNull
    private String username;
    @NotNull
    @Min(5)
    @Max(12)
    private String password;
    @NotNull
    @Email
    private String email;
}
