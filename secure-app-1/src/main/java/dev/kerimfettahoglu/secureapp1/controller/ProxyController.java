package dev.kerimfettahoglu.secureapp1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redirector")
public class ProxyController {
    private final RestTemplate restTemplate;

    @PreAuthorize("hasAuthority('HMS Victory')")
    @GetMapping(path = "/check/victory")
    public ResponseEntity<String> victory() {
        String fooResourceUrl = "http://localhost:8082/victory";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        return response;
    }

    @PreAuthorize("hasAuthority('HMS Anadolu')")
    @GetMapping(path = "/check/anadolu")
    public ResponseEntity<String> anadolu() {
        String fooResourceUrl = "http://localhost:8082/check/anadolu";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        return response;
    }

    @GetMapping(path = "/check/auths")
    public ResponseEntity<String> auths() {
        String fooResourceUrl = "http://localhost:8082/check/auths";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        return response;
    }

    @GetMapping(path = "/check/up")
    public ResponseEntity<String> checkUp() {
        String fooResourceUrl = "http://localhost:8082/check/up";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        return response;
    }

    @GetMapping(path = "/public/check")
    public ResponseEntity<String> publicWs() {
        String fooResourceUrl = "http://localhost:8082/public/check";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        return response;
    }

}
