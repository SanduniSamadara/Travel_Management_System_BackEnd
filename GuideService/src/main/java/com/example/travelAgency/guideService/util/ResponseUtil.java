package com.example.travelAgency.guideService.util;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class ResponseUtil<T> {
    private int code;
    private String message;
    private T data;

}
