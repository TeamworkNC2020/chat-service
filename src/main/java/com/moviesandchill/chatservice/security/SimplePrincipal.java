package com.moviesandchill.chatservice.security;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.security.Principal;

@Data
@AllArgsConstructor
public class SimplePrincipal implements Principal {

    private final long userId;

    @Override
    public String getName() {
        return String.valueOf(userId);
    }
}
