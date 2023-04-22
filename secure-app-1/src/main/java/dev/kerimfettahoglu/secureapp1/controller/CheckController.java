package dev.kerimfettahoglu.secureapp1.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/check")
public class CheckController {
    @GetMapping("/up")
    public String check() {
        return "Up";
    }

    @GetMapping(path = "/auths")
    public Map<String,Object> auths(JwtAuthenticationToken principal) {
        Collection<String> authorities = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        Map<String,Object> info = new HashMap<>();
        info.put("name", principal.getName());
        info.put("authorities", authorities);
        return info;
    }
}
