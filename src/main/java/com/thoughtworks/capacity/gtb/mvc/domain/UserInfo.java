package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private Integer id;
    @NotBlank(message = Constants.USERNAME_EMPTY_ERROR)
    @Length(min = Constants.USERNAME_MIN_LENGTH, max = Constants.USERNAME_MAX_LENGTH,
            message = Constants.USERNAME_LENGTH_ERROR)

    private String username;
    @NotBlank(message = Constants.PASSWORD_EMPTY_ERROR)
    @Length(min = Constants.PASSWORD_MIN_LENGTH, max = Constants.PASSWORD_MAX_LENGTH,
            message = Constants.PASSWORD_LENGTH_ERROR)

    private String password;
    @Email(message = Constants.EMAIL_CONTENT_ERROR)
    private String email;
}
