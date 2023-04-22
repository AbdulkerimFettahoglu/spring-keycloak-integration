package dev.kerimfettahoglu.secureapp1.config;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public class JwtTokenInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        Object obj = SecurityContextHolder.getContext().getAuthentication().getCredentials();
        if (obj instanceof Jwt) {
            Jwt jwt = (Jwt) obj;
            headers.add("Authorization", "Bearer " + jwt.getTokenValue());
        }
        return execution.execute(request, body);
    }
}
