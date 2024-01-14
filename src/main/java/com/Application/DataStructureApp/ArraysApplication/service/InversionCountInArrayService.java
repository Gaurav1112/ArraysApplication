package com.Application.DataStructureApp.ArraysApplication.service;

import com.Application.DataStructureApp.ArraysApplication.model.ResponseModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InversionCountInArrayService {

    public ResponseModel inversionCount(int[] arr){
        ResponseModel responseModel = new ResponseModel();
        int n = arr.length;
        int count=0;
        for (int i=0; i<n-1; i++){
            for(int j=i; j<n; j++){
                if(arr[i] > arr[j])
                    count++;
            }
        }
        int[] responseArray = new int[]{count};

        responseModel.setResponseArray(responseArray);
        List<String> theoryPortion = new ArrayList<>();
        theoryPortion.add("Follow the below steps to Implement the idea:\n" +
                "\n" +
                "Traverse through the array from start to end\n" +
                "For every element, find the count of elements smaller than the current number up to that index using another loop.\n" +
                "Sum up the count of inversion for every index.\n" +
                "Print the count of inversions.");
        responseModel.setTheoryPortion(theoryPortion);

        List<String> responseCode = new ArrayList<>();
        responseCode.add("public ResponseModel inversionCount(int[] arr){\n" +
                "        ResponseModel responseModel = new ResponseModel();\n" +
                "        int n = arr.length;\n" +
                "        int count=0;\n" +
                "        for (int i=0; i<n-1; i++){\n" +
                "            for(int j=i; j<n; j++){\n" +
                "                if(arr[i] > arr[j])\n" +
                "                    count++;\n" +
                "            }\n" +
                "        }\n" +
                "        int[] responseArray = new int[]{count};\n" +
                "\n" +
                "        responseModel.setResponseArray(responseArray);\n" +
                "        List<String> theoryPortion = new ArrayList<>();\n" +
                "        theoryPortion.add(\"Follow the below steps to Implement the idea:\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Traverse through the array from start to end\\n\" +\n" +
                "                \"For every element, find the count of elements smaller than the current number up to that index using another loop.\\n\" +\n" +
                "                \"Sum up the count of inversion for every index.\\n\" +\n" +
                "                \"Print the count of inversions.\");\n" +
                "        responseModel.setTheoryPortion(theoryPortion);\n" +
                "\n" +
                "        return responseModel;\n" +
                "    }");
        responseModel.setResponseCode(responseCode);

        return responseModel;
    }

    public ResponseModel inversionCountByMergeSort(int[] arr){
        int n = arr.length;
        ResponseModel responseModel = new ResponseModel();
        int val = inversionCountUtil(arr, 0, n-1);

        int[] responseArray = new int[] {val};
        responseModel.setResponseArray(responseArray);
        List<String> theoryPortion = new ArrayList<>();
        theoryPortion.add("The idea is similar to merge sort, divide the array into two equal or almost equal halves in each step until the base case is reached.\n" +
                "Create a function merge that counts the number of inversions when two halves of the array are merged, \n" +
                "Create two indices i and j, i is the index for the first half, and j is an index of the second half. \n" +
                "If a[i] is greater than a[j], then there are (mid – i) inversions because left and right subarrays are sorted, so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j].\n" +
                "Create a recursive function to divide the array into halves and find the answer by summing the number of inversions in the first half, the number of inversions in the second half and the number of inversions by merging the two.\n" +
                "The base case of recursion is when there is only one element in the given half.\n" +
                "Print the answer.");
        responseModel.setTheoryPortion(theoryPortion);
        List<String> responseCode = new ArrayList<>();
        responseCode.add("  public ResponseModel inversionCountByMergeSort(int[] arr){\n" +
                "        int n = arr.length;\n" +
                "        ResponseModel responseModel = new ResponseModel();\n" +
                "        int val = inversionCountUtil(arr, 0, n-1);\n" +
                "\n" +
                "        int[] responseArray = new int[] {val};\n" +
                "        responseModel.setResponseArray(responseArray);\n" +
                "        List<String> theoryPortion = new ArrayList<>();\n" +
                "        theoryPortion.add(\"The idea is similar to merge sort, divide the array into two equal or almost equal halves in each step until the base case is reached.\\n\" +\n" +
                "                \"Create a function merge that counts the number of inversions when two halves of the array are merged, \\n\" +\n" +
                "                \"Create two indices i and j, i is the index for the first half, and j is an index of the second half. \\n\" +\n" +
                "                \"If a[i] is greater than a[j], then there are (mid – i) inversions because left and right subarrays are sorted, so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j].\\n\" +\n" +
                "                \"Create a recursive function to divide the array into halves and find the answer by summing the number of inversions in the first half, the number of inversions in the second half and the number of inversions by merging the two.\\n\" +\n" +
                "                \"The base case of recursion is when there is only one element in the given half.\\n\" +\n" +
                "                \"Print the answer.\");\n" +
                "        responseModel.setTheoryPortion(theoryPortion);\n" +
                "        return responseModel;\n" +
                "    }\n" +
                "\n" +
                "    private int inversionCountUtil(int[] arr, int l, int r) {\n" +
                "        int count =0 ;\n" +
                "\n" +
                "        if(l<r){\n" +
                "            int m = (l+r)/2;\n" +
                "            count += inversionCountUtil(arr, l, m);\n" +
                "            count += inversionCountUtil(arr, m+1, r);\n" +
                "            count += mergeAnCount(arr, l, m, r);\n" +
                "        }\n" +
                "        return count;\n" +
                "    }\n" +
                "\n" +
                "    private int mergeAnCount(int[] arr, int l, int m, int r) {\n" +
                "\n" +
                "        int[] left = Arrays.copyOfRange(arr, l, m+1);\n" +
                "        int[] right = Arrays.copyOfRange(arr, m+1, r+1);\n" +
                "\n" +
                "        int i=0, j=0, k=l, swaps = 0;\n" +
                "\n" +
                "        while(i < left.length && j < right.length){\n" +
                "            if(left[i] <= right[j])\n" +
                "                arr[k++] = left[i++];\n" +
                "            else {\n" +
                "                arr[k++] = right[j++];\n" +
                "                swaps += (m+1) - (l + i);\n" +
                "            }\n" +
                "        }\n" +
                "        while(i<left.length)\n" +
                "            arr[k++] = left[i++];\n" +
                "        while (j<right.length)\n" +
                "            arr[k++] = right[j++];\n" +
                "        return swaps;\n" +
                "    }");
        responseModel.setResponseCode(responseCode);
        return responseModel;
    }

    private int inversionCountUtil(int[] arr, int l, int r) {
        int count =0 ;

        if(l<r){
            int m = (l+r)/2;
            count += inversionCountUtil(arr, l, m);
            count += inversionCountUtil(arr, m+1, r);
            count += mergeAnCount(arr, l, m, r);
        }
        return count;
    }

    private int mergeAnCount(int[] arr, int l, int m, int r) {

        int[] left = Arrays.copyOfRange(arr, l, m+1);
        int[] right = Arrays.copyOfRange(arr, m+1, r+1);

        int i=0, j=0, k=l, swaps = 0;

        while(i < left.length && j < right.length){
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m+1) - (l + i);
            }
        }
        while(i<left.length)
            arr[k++] = left[i++];
        while (j<right.length)
            arr[k++] = right[j++];
        return swaps;
    }
}
