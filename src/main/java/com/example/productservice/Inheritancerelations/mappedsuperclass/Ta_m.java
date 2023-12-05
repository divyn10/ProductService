package com.example.productservice.Inheritancerelations.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ta_m extends User_m {
    private String ta_session;
}
