package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.security.model.AuthenticationResponse;
import com.ecommerce.ecommerce.security.model.AuthenticationRequest;

public interface AuthenticationService {
    AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception;

}
