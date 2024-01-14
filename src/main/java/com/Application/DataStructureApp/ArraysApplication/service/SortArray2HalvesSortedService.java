package com.Application.DataStructureApp.ArraysApplication.service;

import com.Application.DataStructureApp.ArraysApplication.model.ResponseModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SortArray2HalvesSortedService {

    /**
     * Method 1: A Simple Solution is to sort the array using built in functions (generally an implementation of quick sort).
     * Below is the implementation of above method:
     *
     * Time Complexity: O(n*log(n))  best & average case, O(n^2)  worst case (for quicksort)
     *
     * Space Complexity: O(log(n))  to O(n)  depending on the case & implementation (for quicksort)
     *
     * @param arr
     * @return
     */
    public ResponseModel sortArraySimpleWay(int[] arr){
        ResponseModel responseModel = new ResponseModel();
        Arrays.sort(arr);
        responseModel.setResponseArray(arr);

        List<String> theoryPortion = new ArrayList<>();
        theoryPortion.add(" A Simple Solution is to sort the array using built in functions (generally an implementation of quick sort). \n" +
                "Below is the implementation of above method: \n" + "Time Complexity: O(n*log(n))  best & average case, O(n^2)  worst case (for quicksort)\n" +
                "\n" +
                "Space Complexity: O(log(n))  to O(n)  depending on the case & implementation (for quicksort)");
        responseModel.setTheoryPortion(theoryPortion);

        List<String> responseCode = new ArrayList<>();
        responseCode.add("  ResponseModel responseModel = new ResponseModel();\n" +
                "        Arrays.sort(arr)\n" +
                "        responseModel.setResponseArray(arr);\n" +
                "\n" +
                "        List<String> theoryPortion = new ArrayList<>();\n" +
                "        theoryPortion.add(\" A Simple Solution is to sort the array using built in functions (generally an implementation of quick sort). \\n\" +\n" +
                "                \"Below is the implementation of above method: \\n\" + \"Time Complexity: O(n*log(n))  best & average case, O(n^2)  worst case (for quicksort)\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Space Complexity: O(log(n))  to O(n)  depending on the case & implementation (for quicksort)\");\n" +
                "        responseModel.setTheoryPortion(theoryPortion);\n" +
                "        return responseModel;");
        responseModel.setResponseCode(responseCode);
        return responseModel;
    }

    /** A more efficient solution is to use an auxiliary array which is very similar to the Merge Function of Merge sort.
     *  Below is the implementation of above approach :
     *  Time Complexity: O(n)
     *  Space Complexity: O(n)
     *  @param arr
     *  @return
     */
    public ResponseModel sortArrayInOptimizedWay(int[] arr){
        ResponseModel responseModel = new ResponseModel();
        mergeTwoHalf(arr);
        responseModel.setResponseArray(arr);
        List<String> theoryPortion = new ArrayList<>();
        theoryPortion.add(" A more efficient solution is to use an auxiliary array which is very similar to the Merge Function of Merge sort. \n"+
                "Time Complexity: O(n)\n" +
                "\n" +
                "Space Complexity: O(n)  ");
        responseModel.setTheoryPortion(theoryPortion);
        List<String> responseCode = new ArrayList<>();
        responseCode.add("private void mergeTwoHalf(int[] arr) {\n" +
                "        int n = arr.length;\n" +
                "        int halfI = 0;\n" +
                "        int i;\n" +
                "\n" +
                "        int[] temp = new int[n];\n" +
                "\n" +
                "        for(i =0; i< n-1; i++){\n" +
                "            if(arr[i] > arr[i+1]){\n" +
                "                halfI = i+1;\n" +
                "                break;\n" +
                "            }\n" +
                "        }\n" +
                "        if( halfI == 0)\n" +
                "            return;\n" +
                "        i=0;\n" +
                "        int j =halfI;\n" +
                "        int k= 0;\n" +
                "        while ((i < halfI && j <n)){\n" +
                "           if(arr[i] < arr[j]){\n" +
                "               temp[k++] = arr[i++];\n" +
                "           } else {\n" +
                "               temp[k++] = arr[j++];\n" +
                "           }\n" +
                "        }\n" +
                "\n" +
                "        while (i< halfI){\n" +
                "            temp[k++] = arr[i++];\n" +
                "        }\n" +
                "        while (j< n){\n" +
                "            temp[k++] = arr[j++];\n" +
                "        }\n" +
                "        for( i=0;  i<n; i++)\n" +
                "            arr[i++] = temp[i++];\n" +
                "    }");
        responseModel.setResponseCode(responseCode);
        return responseModel;
    }

    private void mergeTwoHalf(int[] arr) {
        int n = arr.length;
        int halfI = 0;
        int i;

        int[] temp = new int[n];

        for(i =0; i< n-1; i++){
            if(arr[i] > arr[i+1]){
                halfI = i+1;
                break;
            }
        }
        if( halfI == 0)
            return;
        i=0;
        int j =halfI;
        int k= 0;
        while (i < halfI && j <n){
           if(arr[i] < arr[j]){
               temp[k++] = arr[i++];
           } else {
               temp[k++] = arr[j++];
           }
        }

        while (i< halfI){
            temp[k++] = arr[i++];
        }
        while (j< n){
            temp[k++] = arr[j++];
        }
        for( i=0;  i<n; i++)
            arr[i] = temp[i];
    }

}
