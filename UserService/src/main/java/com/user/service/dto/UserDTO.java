package com.user.service.dto;

import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserDTO {
    private String userId;
    private String name;
    private String email;
    private String about;
    private List<Rating> ratings;
}
