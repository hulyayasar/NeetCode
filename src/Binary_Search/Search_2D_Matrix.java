package Binary_Search;

public class Search_2D_Matrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int lengthC = matrix.length;
        if(lengthC == 0)return false;
        int lengthR = matrix[0].length-1;

        for(int i =0; i<lengthC; i++){

            if(matrix[i][0]<= target && target<=matrix[i][lengthR]){
                int left=0, right =lengthR;
                while(left<=right){
                    int mid = (left + right)/2;
                    if(matrix[i][mid] == target){
                       return true;
                    }
                    else if(matrix[i][mid] < target){
                        left=mid +1;
                    }
                    else{
                        right = mid -1;
                    }
                }
            }
        }

        return false;
    }

    public static boolean searchMatrix_2(int[][]matrix, int target){
        int lengthColumn = matrix.length;
        if(lengthColumn == 0)return false;
        int lengthRow = matrix[0].length;

        int top =0,bottom=lengthColumn-1;
        int row=0;
        while(top<=bottom){
            row = (top+bottom)/2;
            if(target < matrix[row][0]){
                bottom=row-1;
            }
            else if(target> matrix[row][lengthRow-1]){
                top = row +1;
            }
            else{
                break;
            }
        }

        if(!(top<=bottom)){
            return false;
        }

        int left = 0, right = lengthRow-1;
        int mid;
        while(left<=right){
            mid = (left+right)/2;
            if (matrix[row][mid] == target){
                return true;
            }
            else if(target> matrix[row][mid]){
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        // Test cases
        int[][] matrix1 = {
                {1, 3, 5},
                {7, 10, 12},
                {14, 16, 18}
        };
        System.out.println(testSearch(matrix1, 10, true)); // Expected: true
        System.out.println(testSearch(matrix1, 1, true)); // Expected: true
        System.out.println(testSearch(matrix1, 18, true)); // Expected: true
        System.out.println(testSearch(matrix1, 13, false)); // Expected: false

        int[][] matrix2 = {
                {1, 3, 5, 7, 9}
        };
        System.out.println(testSearch(matrix2, 7, true)); // Expected: true

        int[][] matrix3 = {
                {1},
                {3},
                {5},
                {7},
                {9}
        };
        System.out.println(testSearch(matrix3, 4, false)); // Expected: false

        int[][] matrix4 = {
                {5, 10, 15},
                {20, 25, 30},
                {35, 40, 45}
        };
        System.out.println(testSearch(matrix4, 1, false)); // Expected: false
        System.out.println(testSearch(matrix4, 50, false)); // Expected: false

        int[][] matrix5 = {};
        System.out.println(testSearch(matrix5, 5, false)); // Expected: false

        int[][] matrix6 = {
                {5}
        };
        System.out.println(testSearch(matrix6, 5, true)); // Expected: true
        System.out.println(testSearch(matrix6, 3, false)); // Expected: false
    }

    // Helper function to validate test cases
    public static String testSearch(int[][] matrix, int target, boolean expected) {
        boolean result = searchMatrix_2(matrix, target);
        return result == expected ? "PASS" : "FAIL: got " + result + " but expected " + expected;

    }



}
