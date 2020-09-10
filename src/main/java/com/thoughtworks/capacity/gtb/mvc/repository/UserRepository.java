package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserRepository {
    UserInfo save(UserInfo userInfo);

    UserInfo findByName(String username);

    Map<String, UserInfo> findAll();
}
