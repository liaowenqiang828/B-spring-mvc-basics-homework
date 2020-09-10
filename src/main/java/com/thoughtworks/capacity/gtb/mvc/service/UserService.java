package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.UserInfo;
import com.thoughtworks.capacity.gtb.mvc.exception.RegisterFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private List<UserInfo> userInfoList = new ArrayList<>();
    public UserService() {
        userInfoList.add(new UserInfo(1, "James", "123456", "james@qq.com"));
        userInfoList.add(new UserInfo(1, "Bryant", "123456", "Bryant@qq.com"));
    }

    public ResponseEntity userRegister(UserInfo userInfo) {
        if (!userInfo.getUsername().matches("[0-9A-Za-z_]*")) {
            throw new RegisterFailedException("username should only contain number or letter or underline");
        }

        if (userInfoList.stream().map(UserInfo::getUsername).collect(Collectors.toList()).indexOf(userInfo.getUsername()) > -1) {
            throw new RegisterFailedException("username should be unique");
        }
        userInfoList.add(userInfo);
        return ResponseEntity.ok().build();
    }
}
