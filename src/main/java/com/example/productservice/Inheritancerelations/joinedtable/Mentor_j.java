package com.example.productservice.Inheritancerelations.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Mentor_j extends User_j{
    private double avgRating;
}
