package com.user.service.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Rating {
    private String userId;
    private String hotelId;
    private int rating;
    private String feedBack;
}
