package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<UserInfo> userInfoList = new ArrayList<>();

    public ResponseEntity userRegister(UserInfo userInfo) {
        userInfoList.add(userInfo);
        return ResponseEntity.ok().build();
    }
}
