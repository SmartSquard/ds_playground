package com.home.test;

import java.util.HashMap;
import java.util.Map;

class SearchSortedMatrix {

    public static void main(String a[]) {
        SearchSortedMatrix s = new SearchSortedMatrix();
        int[][] matrix = new int[][]{{1}};
        System.out.println(s.searchMatrix(matrix, 1));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (matrix == null || m == 0) {
            return false;
        } else if (m==1 && matrix[0].length == 0) {
            return false;
        }
        int i=0;
        for(i=0;i<m;i++) {
            if (target > matrix[i][0]) {
                continue;
            }
            break;
        }
        //Do binary search on i-1 row.
        int low = 0;
        int high = matrix[i-1].length-1;
        while(low<=high) {
            int mid = (high + low)/  2;
            if (matrix[i-1][mid] == target) {
                return true;
            } else if (matrix[i-1][mid] < target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return false;
    }
}