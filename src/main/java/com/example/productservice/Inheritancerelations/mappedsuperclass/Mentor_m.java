package com.example.productservice.Inheritancerelations.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Mentor_m extends User_m {
    private double avgRating;
}
