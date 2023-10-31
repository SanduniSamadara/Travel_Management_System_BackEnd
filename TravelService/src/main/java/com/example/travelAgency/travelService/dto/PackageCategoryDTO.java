package com.example.travelAgency.travelService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PackageCategoryDTO {

    private String regular;
    private String midLevel;
    private String luxury;
    private String superLuxury;

}
