package com.example.travelAgency.travelService.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
@Table(name = "travelDuration")
public class Duration {
    @NotEmpty(message = "Start Date shouldn't be empty")
    private Date start_date;
    @NotEmpty(message = "End Date shouldn't be empty")
    private Date end_date;
    @Min(value = 1, message = "Day count shouldn't be less than 0")
    private int count_on_days;
    @Min(value = 1, message = "Day count shouldn't be less than 0")
    private int count_on_nights;
}
