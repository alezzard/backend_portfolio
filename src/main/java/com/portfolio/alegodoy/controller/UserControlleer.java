package com.portfolio.alegodoy.controller;

import com.portfolio.alegodoy.model.Persona;
import com.portfolio.alegodoy.service.IPersonaService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")//("*")
public class UserControlleer {

    @Autowired
    private IPersonaService iPersonaService;

    @PostMapping
    public ResponseEntity<Persona> login(@RequestBody Persona user){
        Persona persona = iPersonaService.findByEmail(user.getEmail());

        if (persona.getPassword().equals(user.getPassword())){
            String token = getJWTToken(user.getEmail());
            persona.setToken(token);
            persona.setPassword(null);
            return ResponseEntity.ok().body(persona);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    private String getJWTToken(String userName){

        String secretKey = "W3L0v3Arg3nt1n4";

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("app17380")
                .setSubject(userName)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512,
                            secretKey.getBytes())
                .compact();

        return "Bearer" + token;
    }
}
