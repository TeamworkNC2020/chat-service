package security;

import com.moviesandchill.chatservice.security.SimplePrincipal;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.AbstractHandshakeHandler;
import org.springframework.web.util.WebUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.security.Principal;
import java.util.Map;

@Slf4j
@Service
public class JwtHandshakeHandler extends AbstractHandshakeHandler {
    private final String secret;

    public JwtHandshakeHandler(String secret) {
        this.secret = secret;
    }


    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        ServletServerHttpRequest servletServerRequest = (ServletServerHttpRequest) request;
        HttpServletRequest servletRequest = servletServerRequest.getServletRequest();
        Cookie tokenCookie = WebUtils.getCookie(servletRequest, "token");

        if (tokenCookie != null) {
            var token = tokenCookie.getValue();
            log.info(String.valueOf(token));
            JwtParser parser = Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build();

            var jws = parser.parseClaimsJws(token);
            long userId = Integer.parseInt(jws.getBody().getSubject());
            return new SimplePrincipal(userId);
        }
        return null;
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(this.secret);
        return new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
    }
}
