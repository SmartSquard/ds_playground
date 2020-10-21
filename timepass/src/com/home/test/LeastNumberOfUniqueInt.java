package com.home.test;

import java.util.*;
import java.util.stream.Collectors;

public class LeastNumberOfUniqueInt {

    public static void main(String a[]) {
        System.out.println(findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3));
    }

        public static int findLeastNumOfUniqueInts(int[] arr, int m) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            Arrays.stream(arr).forEach(i -> {
                if (map.get(i) == null) {
                    map.put(i,1);
                } else {
                    map.put(i, map.get(i) + 1);
                }
            });

            Map<Integer, Integer> nmap = map.entrySet().stream().sorted((k1, k2) -> -k2.getValue().compareTo(k1.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
            int i  = 0;
            Iterator<Map.Entry<Integer,Integer>> it = nmap.entrySet().iterator();
            while(i < m){
                Map.Entry<Integer,Integer> pair = (Map.Entry<Integer,Integer>) it.next();
                i += pair.getValue();
            }
            int j = i > m ? 1 : 0;
            while(it.hasNext()){
                Map.Entry<Integer,Integer> pair = (Map.Entry<Integer,Integer>) it.next();
                j++;
            }
            return j;
        }

}
