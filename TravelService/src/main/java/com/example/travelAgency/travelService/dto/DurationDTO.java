package com.example.travelAgency.travelService.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Embeddable
public class DurationDTO {
    private Date start_date;
    private Date end_date;
    private int count_on_days;
    private int count_on_nights;
}
