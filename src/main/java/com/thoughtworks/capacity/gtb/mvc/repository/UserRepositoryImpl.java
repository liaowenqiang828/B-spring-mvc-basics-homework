package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<String, UserInfo> userInfoList = new HashMap<>();

    @Override
    public UserInfo save(UserInfo userInfo) {
        userInfo.setId(userInfoList.size() + 1);
        userInfoList.put(userInfo.getUsername(), userInfo);
        return userInfo;
    }

    @Override
    public UserInfo findByName(String username) {
        return userInfoList.get(username);
    }

    @Override
    public Map<String, UserInfo> findAll() {
        return userInfoList;
    }
}
