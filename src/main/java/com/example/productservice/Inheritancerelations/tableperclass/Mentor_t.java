package com.example.productservice.Inheritancerelations.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Mentor_t extends User_t {
    private double avgRating;
}
