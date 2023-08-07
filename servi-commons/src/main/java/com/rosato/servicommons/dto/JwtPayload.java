package com.rosato.servicommons.dto;

import com.rosato.servicommons.enums.Role;
import lombok.Data;
import java.util.Set;

@Data
public class JwtPayload {
    private Long userId;
    private String username;
    private Set<Role> roles;
    private String issuer;
    private Long expiration;
}
