package com.example.productservice.Inheritancerelations.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ta_t extends User_t {
    private String ta_session;
}
