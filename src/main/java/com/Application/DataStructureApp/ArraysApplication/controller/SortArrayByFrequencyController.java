package com.Application.DataStructureApp.ArraysApplication.controller;

import com.Application.DataStructureApp.ArraysApplication.model.RequestModel;
import com.Application.DataStructureApp.ArraysApplication.model.ResponseModel;
import com.Application.DataStructureApp.ArraysApplication.service.SortArrayByFrequencyService;
import com.Application.DataStructureApp.ArraysApplication.service.SortArrayInWaveFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/arraysFreq")
public class SortArrayByFrequencyController {
    final SortArrayByFrequencyService sortArrayByFrequencyService;

    @Autowired
    public SortArrayByFrequencyController(SortArrayByFrequencyService sortArrayByFrequencyService) {
        this.sortArrayByFrequencyService = sortArrayByFrequencyService;
    }

    @GetMapping("/show")
    public String show(Model model) {
        // Initialize an empty RequestModel to bind with the form
        RequestModel requestModel = new RequestModel();
        model.addAttribute("requestModel", requestModel);

        // Initialize an empty ResponseModel to display initial results (if needed)
        ResponseModel responseModel = new ResponseModel();
        model.addAttribute("responseModel", responseModel);

        return "sortArrayByFrequencyAndValue";
    }
    @PostMapping("/sortArrayByFrequencyAndVal")
    @ResponseBody
    public ResponseEntity<ResponseModel> sortArrayByFrequencyAndVal(@RequestBody Map<String, String> requestBody) {
        try {
            String requestArrayStr = requestBody.get("requestArray");
            int[] requestArray = Arrays.stream(requestArrayStr.split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            ResponseModel responseModel = sortArrayByFrequencyService.sortBasedOnFreqandValue(requestArray);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/sortArrayByFrequencyAndValOptimized")
    @ResponseBody
    public ResponseEntity<ResponseModel> sortArrayByFrequencyAndValOptimized(@RequestBody Map<String, String> requestBody) {
        try {
            String requestArrayStr = requestBody.get("requestArray");
            int[] requestArray = Arrays.stream(requestArrayStr.split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            ResponseModel responseModel = new ResponseModel();
            responseModel = sortArrayByFrequencyService.sortArrayByFrequencyUsingHeap(requestArray);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
