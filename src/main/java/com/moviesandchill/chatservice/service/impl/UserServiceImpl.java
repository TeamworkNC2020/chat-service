package com.moviesandchill.chatservice.service.impl;

import com.moviesandchill.chatservice.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${endpoint.user-service.url}")
    private String userServiceUrl;

    @Override
    public void setOnline(long userId, boolean isOnline) {
        String url = userServiceUrl + "/api/v1/users/" + userId + "/online";
        restTemplate.postForObject(url, isOnline, Void.class);
    }
}
