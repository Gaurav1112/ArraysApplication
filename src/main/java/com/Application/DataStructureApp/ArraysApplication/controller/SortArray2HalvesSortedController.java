package com.Application.DataStructureApp.ArraysApplication.controller;

import com.Application.DataStructureApp.ArraysApplication.model.RequestModel;
import com.Application.DataStructureApp.ArraysApplication.model.ResponseModel;
import com.Application.DataStructureApp.ArraysApplication.service.SortArray2HalvesSortedService;
import com.Application.DataStructureApp.ArraysApplication.service.SortArrayByFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/arraysSort")
public class SortArray2HalvesSortedController {

    final SortArray2HalvesSortedService sortArray2HalvesSortedService;

    @Autowired
    public SortArray2HalvesSortedController(SortArray2HalvesSortedService sortArray2HalvesSortedService) {
        this.sortArray2HalvesSortedService = sortArray2HalvesSortedService;
    }

    @GetMapping("/show")
    public String show(Model model) {
        // Initialize an empty RequestModel to bind with the form
        RequestModel requestModel = new RequestModel();
        model.addAttribute("requestModel", requestModel);

        // Initialize an empty ResponseModel to display initial results (if needed)
        ResponseModel responseModel = new ResponseModel();
        model.addAttribute("responseModel", responseModel);

        return "sortArray2HalvesSorted";
    }
    @PostMapping("/sortArraySimpleWay")
    @ResponseBody
    public ResponseEntity<ResponseModel> sortArrayInSimpleWay(@RequestBody Map<String, String> requestBody) {
        try {
            String requestArrayStr = requestBody.get("requestArray");
            int[] requestArray = Arrays.stream(requestArrayStr.split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            ResponseModel responseModel = sortArray2HalvesSortedService.sortArraySimpleWay(requestArray);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/sortArraySimpleWayOptimized")
    @ResponseBody
    public ResponseEntity<ResponseModel> sortArrayInOptimizedWay(@RequestBody Map<String, String> requestBody) {
        try {
            String requestArrayStr = requestBody.get("requestArray");
            int[] requestArray = Arrays.stream(requestArrayStr.split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            ResponseModel responseModel = new ResponseModel();
            responseModel = sortArray2HalvesSortedService.sortArrayInOptimizedWay(requestArray);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
