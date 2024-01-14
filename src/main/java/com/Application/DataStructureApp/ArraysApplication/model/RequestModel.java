package com.Application.DataStructureApp.ArraysApplication.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RequestModel {
    private int[] requestArray;
}
