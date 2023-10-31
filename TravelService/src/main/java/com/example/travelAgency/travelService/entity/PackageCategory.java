package com.example.travelAgency.travelService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PackageCategory {

    private String regular;
    private String midLevel;
    private String luxury;
    private String superLuxury;

}
