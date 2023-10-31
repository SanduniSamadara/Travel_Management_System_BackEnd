package com.example.travelAgency.hotelService.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Embeddable
@Table(name = "contact")
public class Contact {
    @NotBlank(message = "ContactNo shouldn't be blank")
    @Pattern(regexp ="^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$" , message = "Invalid contact number")
    private String contact_one;
    @Pattern(regexp ="^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$" , message = "Invalid contact number")
    private String contact_two;
}
