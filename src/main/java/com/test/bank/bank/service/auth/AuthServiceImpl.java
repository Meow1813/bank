package com.test.bank.bank.service.auth;

import com.test.bank.bank.domain.dto.JwtRequest;
import com.test.bank.bank.domain.dto.JwtResponse;
import com.test.bank.bank.exception.AppError;
import com.test.bank.bank.service.user.CustomUserDetailsService;
import com.test.bank.bank.util.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    CustomUserDetailsService userDetailsService;
    @Override
    public ResponseEntity<?> creteAuthToken(JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        }catch (BadCredentialsException e){
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(),"Неправильный логин или пароль"), HttpStatus.UNAUTHORIZED);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
