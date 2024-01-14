package com.Application.DataStructureApp.ArraysApplication.service;

import com.Application.DataStructureApp.ArraysApplication.model.ResponseModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Given an array of positive integers, sort the array in decreasing order of count of set bits in binary representations of array elements.
 * For integers having the same number of set bits in their binary representation, sort according to their position in the original array i.e.,
 * a stable sort. For example, if the input array is {3, 5}, then the output array should also be {3, 5}.
 * Note that both 3 and 5 have the same number set bits.
 */
@Service
public class SortArrayBasedOnBitCountService {
    /**
     * Method 1: Simple
     *
     * Create an auxiliary array and store the set-bit counts of all integers in the aux array
     * Simultaneously sort both arrays according to the non-increasing order of auxiliary array. (Note that we need to use a stable sort algorithm)
     * Auxiliary Space: O(n)
     * Time complexity: O(n2)
     * @param arr
     * @return
     */
    public ResponseModel sortByBitCount(int[] arr){
        ResponseModel responseModel = new ResponseModel();
        int n =arr.length;
        int[] aux = new int[n];
        for(int i=0; i<n; i++)
            aux[i] = countBits(arr[i]);
        insertionSort(arr, aux, n);
        responseModel.setResponseArray(arr);
        List<String> theoryPortion = new ArrayList<>();
        theoryPortion.add("Create an auxiliary array and store the set-bit counts of all integers in the aux array\n" +
                "     * Simultaneously sort both arrays according to the non-increasing order of auxiliary array. (Note that we need to use a stable sort algorithm) \n" +
                "Auxiliary Space: O(n)\n" +
                "Time complexity: O(n2)");
        responseModel.setTheoryPortion(theoryPortion);

        List<String> responseCode = new ArrayList<>();
        responseCode.add("private void insertionSort(int[] arr, int[] aux, int n) {\n" +
                "        for( int i=1; i<n; i++) {\n" +
                "            int key1 = aux[i];\n" +
                "            int key2 = arr[i];\n" +
                "            int j = i - 1;\n" +
                "            while (j > 0 && aux[j] < key1) {\n" +
                "                aux[j+1] = aux[j];\n" +
                "                arr[j+1] = arr[j];\n" +
                "                j = j - 1;\n" +
                "            }\n" +
                "            aux[j+1] = key1;\n" +
                "            arr[j+1] = key2;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    private int countBits(int i) {\n" +
                "        int count =0;\n" +
                "        while ( i > 0) {\n" +
                "            if ((i & 1) > 0)\n" +
                "                count += 1;\n" +
                "            i = i >> 1;\n" +
                "        }\n" +
                "        return count;\n" +
                "    }");
        responseModel.setResponseCode(responseCode);
        return responseModel;
    }

    private void insertionSort(int[] arr, int[] aux, int n) {
        for( int i=1; i<n; i++) {
            int key1 = aux[i];
            int key2 = arr[i];
            int j = i - 1;
            while (j > 0 && aux[j] < key1) {
                aux[j+1] = aux[j];
                arr[j+1] = arr[j];
                j = j - 1;
            }
            aux[j+1] = key1;
            arr[j+1] = key2;
        }
    }

    private int countBits(int i) {
        int count =0;
        while ( i > 0) {
            if ((i & 1) > 0)
                count += 1;
            i = i >> 1;
        }
        return count;
    }

    /**
     * Counting Sort based
     *
     * This problem can be solved in O(n) time. The idea is similar to counting sort.
     *
     * Note: There can be a minimum 1 set-bit and only a maximum of 31set-bits in an integer.
     *
     * Steps (assuming that an integer takes 32 bits):
     *
     * Create a vector “count” of size 32. Each cell of count i.e., count[i] is another vector that stores all the elements whose set-bit-count is i
     * Traverse the array and do the following for each element:
     * Count the number set-bits of this element. Let it be ‘setbitcount’
     * count[setbitcount].push_back(element)
     * Traverse ‘count’ in reverse fashion(as we need to sort in non-increasing order) and modify the array.
     * @param arr
     * @return
     */
    public ResponseModel sortByBitCountOptimized(int[] arr){
        ResponseModel responseModel = new ResponseModel();

        // Function to sort according to
        // bit count. This function assumes
        // that there are 32 bits in an integer.
        Vector<Integer> [] count = new Vector[32];
        for(int i=0; i<count.length; i++)
            count[i] = new Vector<Integer>();
        int setBitCount = 0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            setBitCount = countBits(arr[i]);
            count[setBitCount].add(arr[i]);
        }


        List<String> responseCode= new ArrayList<>();
        responseCode.add("Vector<Integer> [] count = new Vector[32];\n" +
                "        for(int i=0; i<count.length; i++)\n" +
                "            count[i] = new Vector<Integer>();\n" +
                "        int setBitCount = 0;\n" +
                "        int n = arr.length;\n" +
                "        for(int i=0; i<n; i++){\n" +
                "            setBitCount = countBits(arr[i]);\n" +
                "            count[setBitCount].add(arr[i]);\n" +
                "        }\n"+
                "       private int countBits(int i) {\n" +
                "        int count =0;\n" +
                "        while ( i > 0) {\n" +
                "            if ((i & 1) > 0)\n" +
                "                count += 1;\n" +
                "            i = i >> 1;\n" +
                "        }\n" +
                "        return count;\n" +
                "    }");
        responseModel.setResponseCode(responseCode);
        List<String> theoryPortion = new ArrayList<>();
        theoryPortion.add("Counting Sort based\n" +
                "\n" +
                "This problem can be solved in O(n) time. The idea is similar to counting sort.\n" +
                "\n" +
                "Note: There can be a minimum 1 set-bit and only a maximum of 31set-bits in an integer.\n" +
                "\n" +
                "Steps (assuming that an integer takes 32 bits):\n" +
                "\n" +
                "Create a vector “count” of size 32. Each cell of count i.e., count[i] is another vector that stores all the elements whose set-bit-count is i\n" +
                "Traverse the array and do the following for each element:\n" +
                "Count the number set-bits of this element. Let it be ‘setbitcount’\n" +
                "count[setbitcount].push_back(element)\n" +
                "Traverse ‘count’ in reverse fashion(as we need to sort in non-increasing order) and modify the array.\n"+
                "time complexity: O(n) space complexity: O(n)");
        responseModel.setTheoryPortion(theoryPortion);
        responseModel.setResponseArray(arr);
        return responseModel;
    }

}
