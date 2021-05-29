package com.moviesandchill.chatservice.security;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.security.Principal;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class SimplePrincipal implements Principal {

    private final long userId;

    @Override
    public String getName() {
        return String.valueOf(userId);
    }
}
