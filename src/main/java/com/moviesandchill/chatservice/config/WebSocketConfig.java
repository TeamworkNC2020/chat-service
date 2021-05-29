package com.moviesandchill.chatservice.config;

import com.moviesandchill.chatservice.security.SimplePrincipal;
import com.moviesandchill.chatservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Configuration
@Slf4j

public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Value("${jwt.token.secret}")
    private String secret;

    @Autowired
    private UserService userService;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setAllowedOrigins(
                        "http://localhost:4200",
                        "https://mac21-ui.herokuapp.com"
                )
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic", "/queue");
        registry.setUserDestinationPrefix("/user");
    }

    @EventListener
    public void onConnectEvent(SessionConnectEvent event) {
        log.info("Client {} connected", event.getUser());

        if (event.getUser() != null) {
            SimplePrincipal user = (SimplePrincipal) event.getUser();
            userService.setOnline(user.getUserId(), true);
        }
    }

    @EventListener
    public void onDisconnectEvent(SessionDisconnectEvent event) {
        log.info("Client {} disconnected", event.getUser());

        if (event.getUser() != null) {
            SimplePrincipal user = (SimplePrincipal) event.getUser();
            userService.setOnline(user.getUserId(), false);
        }
    }

}
