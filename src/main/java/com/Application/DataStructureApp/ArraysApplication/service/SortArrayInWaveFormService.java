package com.Application.DataStructureApp.ArraysApplication.service;

import com.Application.DataStructureApp.ArraysApplication.model.ResponseModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SortArrayInWaveFormService {
    /** Idea is to use sorting and then swap all the adjacent elements
     *      Sort the array.
     *      Traverse the array from index 0 to n-1, and increase the value of index by 2
     *      While traversing the array swap arr[i] and arr[i+1]
     *      Print the final array
     *      time complexity in this Case is: O(N*log(N))
     *      Auxiliary Space: O(1)
     *
     * @param arr
     */
    void populateDescription(int[] arr, int n, List<String> dryRuns){

        String result = "";
        for(int i=-0; i<n; i++)
            result += arr[i] + " ";
        dryRuns.add(result + "\n");
    }
   public ResponseModel sortArrayInWaveForm(int[] arr){
        List<String> responsecode = new ArrayList<>();
        int n = arr.length;
       responsecode.add(" int n = arr.length;\n");
       List<String> dryRuns = new ArrayList<>();
       responsecode.add(" List<String> dryRuns = new ArrayList<>();\n");
       dryRuns.add("sortArrayInWaveForm\n");
        Arrays.sort(arr);
       responsecode.add(" Arrays.sort(arr);\n");
       dryRuns.add("sortArrayInWaveForm : Sorted Array\n");
       populateDescription(arr, n, dryRuns);
       responsecode.add(" populateDescription(arr, n);\n");
       String additionalInfo = "";
       String responseString = "";
        for (int i=0; i<n-1; i +=2){
            responseString = " for (int i=0; i<n-1; i +=2){" + "&lt;br&gt;\n";
            responsecode.add(responseString);
            additionalInfo += "swapping elements are: arr[i] ->  arr[" + i + "]: " + arr[i] + " and arr[i+1] -> arr["+ i+1+ "]: " + arr[i+1] + "\n";
            swap(arr, i, i+1);
            responseString = "  swap(arr, i, i+1);" + "\n";
            responsecode.add(responseString);
            additionalInfo += "swapped elements are: arr[i] ->  arr[" + i + "]: " + arr[i] + " and arr[i+1] -> arr["+ i+1+ "]: " + arr[i+1] + "\n";
        }
        dryRuns.add(additionalInfo);
       dryRuns.add("sortArrayInWaveForm : Swapped Element Array:\n");
       populateDescription(arr, n, dryRuns);
       ResponseModel responseModel = new ResponseModel();
       responsecode.add("  ResponseModel responseModel = new ResponseModel();\n");
        responseModel.setResponseArray(arr);
       responsecode.add("  responseModel.setResponseArray(arr);\n");
        responseModel.setDescription(dryRuns);
        responseModel.setResponseCode(responsecode);
       responsecode.add("  responseModel.setResponseCode(responsecode);\n");
       responsecode.add("  return responseModel");
       responseModel.setResponseCode(responsecode);
       List<String> theoryPortion = new ArrayList<>();
       String theory ="";
       theory += "A idea is to use sorting. First sort the input array, then swap all adjacent elements." + "\n";
       theoryPortion.add(theory);
       theory = "Follow the steps mentioned below to implement the idea:" + "\n";
       theoryPortion.add(theory);
       theory = "Sort the array." + "\n";
       theoryPortion.add(theory);
       theory = "Traverse the array from index 0 to N-1, and increase the value of the index by 2." + "\n";
       theoryPortion.add(theory);
       theory = "While traversing the array swap arr[i] with arr[i+1]." + "\n";
       theoryPortion.add(theory);
       theory = "Print the final array." + "\n";
       theoryPortion.add(theory);
       responseModel.setTheoryPortion(theoryPortion);
        return responseModel;

    }

    /** Idea is based on the fact that if we consider all the even positioned elements
     *  (at index 0, 2, 4, 6..) are greater than their adjacent odd elements,
     *  we do not need to worry about odd positioned elements
     *
     *      Traverse all the even elements of the input array, and do following:
     *          If the current element is smaller than the previous odd element, swap the previous and current
     *          If the current element is smaller than the next odd element, swap next and current.
     *   time complexity: O(N)
     *   space complexity: O(1)
     *
     * @param arr
     */
    public ResponseModel sortArrayInWaveFormOptimized(int[] arr){

        int n = arr.length;
        List<String> dryRuns = new ArrayList<>();
        dryRuns.add("sortArrayInWaveForm\n");
        String additionalInfo = "";
        for (int i=0; i<n; i+=2){
            if (i > 0 && arr[i-1] > arr[i]) {
                additionalInfo += "swapping elements are: arr[i] ->  arr[" + i + "]: " + arr[i] + " and arr[i-1] -> arr["+ (i-1) + "]: " + arr[i-1] + "\n";

                swap(arr, i, i - 1);
            }
            if ( i < n-1 && arr[i+1] > arr[i]){
                additionalInfo += "swapping elements are: arr[i] ->  arr[" + i + "]: " + arr[i] + " and arr[i+1] -> arr["+ i+1+ "]: " + arr[i+1] + "\n";
                swap(arr, i, i+1);
            }

        }
        dryRuns.add(additionalInfo);
        ResponseModel responseModel = new ResponseModel();
        responseModel.setResponseArray(arr);
        responseModel.setDescription(dryRuns);
        return responseModel;

    }

    /**
     * swap the array elements i and j
     * @param arr
     * @param i
     * @param j
     */

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * print the elements in the array arr
     * @param arr
     */



}
