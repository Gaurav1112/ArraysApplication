package com.Application.DataStructureApp.ArraysApplication.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ResponseModel {
    private int[] responseArray;
    private List<String> description;
    private List<String> responseCode;
    private List<String> theoryPortion;
}
