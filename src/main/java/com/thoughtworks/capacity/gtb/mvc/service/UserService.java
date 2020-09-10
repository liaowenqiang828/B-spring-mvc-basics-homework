package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.Constants;
import com.thoughtworks.capacity.gtb.mvc.domain.UserInfo;
import com.thoughtworks.capacity.gtb.mvc.exception.RegisterFailedException;
import com.thoughtworks.capacity.gtb.mvc.exception.UsernameOrPasswordNotMatchException;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

        userRepository.save(UserInfo.builder().id(1).username("Bryant").password("123456").email("bryant@qq.com").build());
        userRepository.save(UserInfo.builder().id(2).username("James").password("1234567").email("james@qq.com").build());
    }

    public void userRegister(UserInfo userInfo) {
        if (!userInfo.getUsername().matches("[0-9A-Za-z_]*")) {
            throw new RegisterFailedException(Constants.USERNAME_CONTENT_ERROR);
        }
        if (userRepository.findAll().containsKey(userInfo.getUsername())) {
            throw new RegisterFailedException(Constants.USERNAME_UNIQUE_ERROR);
        }
        userRepository.save(userInfo);
    }

    public UserInfo userLogin(String username, String password) {
        if (!userRepository.findAll().containsKey(username) || !userRepository.findByName(username).getPassword().equals(password)) {
            throw new UsernameOrPasswordNotMatchException(Constants.LOGIN_FAILED_ERROR);
        }
        return userRepository.findByName(username);
    }
}
