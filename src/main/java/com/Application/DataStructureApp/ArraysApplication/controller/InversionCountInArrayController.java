package com.Application.DataStructureApp.ArraysApplication.controller;

import com.Application.DataStructureApp.ArraysApplication.model.RequestModel;
import com.Application.DataStructureApp.ArraysApplication.model.ResponseModel;
import com.Application.DataStructureApp.ArraysApplication.service.InversionCountInArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/arraysInv")
public class InversionCountInArrayController {
    final InversionCountInArrayService inversionCountInArrayService;

    @Autowired
    public InversionCountInArrayController(InversionCountInArrayService inversionCountInArrayService) {
        this.inversionCountInArrayService = inversionCountInArrayService;
    }

    @GetMapping("/show")
    public String show(Model model) {
        // Initialize an empty RequestModel to bind with the form
        RequestModel requestModel = new RequestModel();
        model.addAttribute("requestModel", requestModel);

        // Initialize an empty ResponseModel to display initial results (if needed)
        ResponseModel responseModel = new ResponseModel();
        model.addAttribute("responseModel", responseModel);

        return "inversionCountInArray";
    }
    @PostMapping("/inversionCountInArray")
    @ResponseBody
    public ResponseEntity<ResponseModel> sortArrayByFrequencyAndVal(@RequestBody Map<String, String> requestBody) {
        try {
            String requestArrayStr = requestBody.get("requestArray");
            int[] requestArray = Arrays.stream(requestArrayStr.split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            ResponseModel responseModel = inversionCountInArrayService.inversionCount(requestArray);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

 @PostMapping("/inversionCountInArrayOptimized")
    @ResponseBody
    public ResponseEntity<ResponseModel> sortArrayByFrequencyAndValOptimized(@RequestBody Map<String, String> requestBody) {
        try {
            String requestArrayStr = requestBody.get("requestArray");
            int[] requestArray = Arrays.stream(requestArrayStr.split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            ResponseModel responseModel = new ResponseModel();
            responseModel = inversionCountInArrayService.inversionCountByMergeSort(requestArray);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
