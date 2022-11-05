package com.akmal.webapi.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String username;
    private Collection<String> roles = new ArrayList<>();
    private String accessToken;
    private String refreshToken;
}
