package com.rating.service.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("ratings")
public class RatingEntity {
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedBack;
}
