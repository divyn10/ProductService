package com.example.productservice.Inheritancerelations.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ta_j extends User_j{
    private String ta_session;
}
