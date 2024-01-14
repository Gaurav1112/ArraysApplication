package com.Application.DataStructureApp.ArraysApplication.service;

import com.Application.DataStructureApp.ArraysApplication.model.ResponseModel;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SortArrayByFrequencyService {

    /**
     *  Using hashing technique, we can store the elements (also the first index) and their counts in a hash.
     *  Finally, sort the hash elements according to their counts
     *
     * @param arr
     */

    public ResponseModel sortBasedOnFreqandValue(int[] arr){
        int n = arr.length;
        final HashMap<Integer, Integer> mapCount
                = new HashMap<Integer, Integer>();
        final HashMap<Integer, Integer> mapIndex
                = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (mapCount.containsKey(arr[i])) {
                mapCount.put(arr[i],
                        mapCount.get(arr[i]) + 1);
            }
            else {
                mapCount.put(
                        arr[i],
                        1); // Map to capture Count of elements
                mapIndex.put(arr[i],
                        i); // Map to capture 1st
                // occurrence of elements
            }
        }
        List<Integer> list =  Arrays.stream(arr).boxed().collect(Collectors.toList());

        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2)
            {
                int freq1 = mapCount.get(n1);
                int freq2 = mapCount.get(n2);
                if (freq1 != freq2) {
                    return freq2 - freq1;
                }
                else {
                    return mapIndex.get(n1)
                            - mapIndex.get(
                            n2); // Elements with Lesser
                    // Index gets Higher
                    // Priority
                }
            }
        });
        ResponseModel responseModel = new ResponseModel();
        responseModel.setResponseArray(list.stream().mapToInt(Integer:: intValue).toArray());
        List<String> theoryPortion = new ArrayList<>();
        theoryPortion.add("Using a hashing mechanism, we can store the elements (also the first index) and their counts in a hash.\n Finally, sort the hash elements according to their counts");
        theoryPortion.add("Time Complexity: O(N log N), where the N is the size of the array\n" +
                "Auxiliary Space: O(N)");
        responseModel.setTheoryPortion(theoryPortion);
        List<String> responseCode= new ArrayList<>();
        responseCode.add("int n = arr.length;\n" +
                "        final HashMap<Integer, Integer> mapCount\n" +
                "                = new HashMap<Integer, Integer>();\n" +
                "        final HashMap<Integer, Integer> mapIndex\n" +
                "                = new HashMap<Integer, Integer>();\n" +
                "        for (int i = 0; i < n; i++) {\n" +
                "            if (mapCount.containsKey(arr[i])) {\n" +
                "                mapCount.put(arr[i],\n" +
                "                        mapCount.get(arr[i]) + 1);\n" +
                "            }\n" +
                "            else {\n" +
                "                mapCount.put(\n" +
                "                        arr[i],\n" +
                "                        1); // Map to capture Count of elements\n" +
                "                mapIndex.put(arr[i],\n" +
                "                        i); // Map to capture 1st\n" +
                "                // occurrence of elements\n" +
                "            }\n" +
                "        }\n" +
                "        List<Integer> list =  Arrays.stream(arr).boxed().collect(Collectors.toList());\n" +
                "\n" +
                "        Collections.sort(list, new Comparator<Integer>() {\n" +
                "            public int compare(Integer n1, Integer n2)\n" +
                "            {\n" +
                "                int freq1 = mapCount.get(n1);\n" +
                "                int freq2 = mapCount.get(n2);\n" +
                "                if (freq1 != freq2) {\n" +
                "                    return freq2 - freq1;\n" +
                "                }\n" +
                "                else {\n" +
                "                    return mapIndex.get(n1)\n" +
                "                            - mapIndex.get(\n" +
                "                            n2); // Elements with Lesser\n" +
                "                    // Index gets Higher\n" +
                "                    // Priority\n" +
                "                }\n" +
                "            }\n" +
                "        });\n" +
                "        ResponseModel responseModel = new ResponseModel();\n" +
                "        responseModel.setResponseArray(list.stream().mapToInt(Integer:: intValue).toArray());");
        responseModel.setResponseCode(responseCode);
        return responseModel;
    }
    public ResponseModel sortArrayByFrequencyUsingHeap(int[] arr){
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : arr)
            map.put(a, map.getOrDefault(a, 0)+1);
        // max heap -as max wise freq elements is what is needed
        PriorityQueue<Map.Entry<Integer, Integer>> maxH = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                if(a.getValue() == b.getValue())
                    return a.getKey().compareTo(b.getKey());
                return b.getValue().compareTo(a.getValue());
            }
        });
        for(Map.Entry<Integer, Integer> m: map.entrySet())
            maxH.add(m);
        // now the max frequency is the top of the max heap
        int i =0;
        while(maxH.size() > 0){
            int val = maxH.peek().getKey();
            int freq = maxH.peek().getValue();

            while(freq-- > 0){
                list.set(i, val);
                i++;
            }
            maxH.poll();
        }
        ResponseModel responseModel = new ResponseModel();
        responseModel.setResponseArray(list.stream().mapToInt(Integer:: intValue).toArray());
        List<String> theoryPortion = new ArrayList<>();
        theoryPortion.add("Follow the given steps to solve the problem:\n" +
                "\n" +
                "Take the arr and use unordered_map to have VALUE : FREQUENCY Table\n" +
                "Then make a HEAP such that high frequency remains at TOP and when frequency is same, just keep in ascending order (Smaller at TOP)\n" +
                "Then After full insertion into Heap\n" +
                "Pop one by one and copy it into the Array");
        responseModel.setTheoryPortion(theoryPortion);
        List<String> responseCode= new ArrayList<>();
        responseCode.add("public ResponseModel sortArrayByFrequencyUsingHeap(int[] arr){\n" +
                "        int n = arr.length;\n" +
                "        List<Integer> list = new ArrayList<>();\n" +
                "        list = Arrays.stream(arr).boxed().collect(Collectors.toList());\n" +
                "        Map<Integer, Integer> map = new HashMap<>();\n" +
                "        for(int a : arr)\n" +
                "            map.put(a, map.getOrDefault(a, 0)+1);\n" +
                "        // max heap -as max wise freq elements is what is needed\n" +
                "        PriorityQueue<Map.Entry<Integer, Integer>> maxH = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {\n" +
                "            @Override\n" +
                "            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {\n" +
                "                if(a.getValue() == b.getValue())\n" +
                "                    return a.getKey().compareTo(b.getKey());\n" +
                "                return b.getValue().compareTo(a.getValue());\n" +
                "            }\n" +
                "        });\n" +
                "        for(Map.Entry<Integer, Integer> m: map.entrySet())\n" +
                "            maxH.add(m);\n" +
                "        // now the max frequency is the top of the max heap\n" +
                "        int i =0;\n" +
                "        while(maxH.size() > 0){\n" +
                "            int val = maxH.peek().getKey();\n" +
                "            int freq = maxH.peek().getValue();\n" +
                "\n" +
                "            while(freq-- > 0){\n" +
                "                list.set(i, val);\n" +
                "                i++;\n" +
                "            }\n" +
                "            maxH.poll();\n" +
                "        }\n" +
                "        ResponseModel responseModel = new ResponseModel();\n" +
                "        responseModel.setResponseArray(list.stream().mapToInt(Integer:: intValue).toArray());\n" +
                "        List<String> theoryPortion = new ArrayList<>();\n" +
                "        theoryPortion.add(\"Follow the given steps to solve the problem:\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Take the arr and use unordered_map to have VALUE : FREQUENCY Table\\n\" +\n" +
                "                \"Then make a HEAP such that high frequency remains at TOP and when frequency is same, just keep in ascending order (Smaller at TOP)\\n\" +\n" +
                "                \"Then After full insertion into Heap\\n\" +\n" +
                "                \"Pop one by one and copy it into the Array\");\n" +
                "        responseModel.setTheoryPortion(theoryPortion);\n" +
                "        List<String> responseCode= new ArrayList<>();\n" +
                "        responseCode.add(\"\");\n" +
                "        responseModel.setResponseCode(responseCode);\n" +
                "        return responseModel;\n" +
                "    }");
        responseModel.setResponseCode(responseCode);
        return responseModel;
    }
}
