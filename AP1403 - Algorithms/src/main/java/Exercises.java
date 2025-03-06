import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercises {

    /*;p
        there is an array of positive integers as input of function and another integer for the target value
        all the algorithm should do is to find those two integers in array which their multiplication is the target
        then it should return an array of their indices
        e.g. {1, 2, 3, 4} with target of 8 -> {1, 3}

        note: you should return the indices in ascending order and every array's solution is unique
    */
    public static int[] productIndices(int[] values, int target) {
    */
    public static int[] spiralTraversal(int[][] values, int rows, int cols) {
        if (values == null || rows == 0 || cols == 0) {
            return new int[0];  // .اگر روردی نا معتبر بود یک ارایه ی خالی چاپ میکنیم
        }
        List<Integer> resultList = new ArrayList<>();
        int startrow = 0 ;
        int endrow = rows - 1 ;
        int startcol = 0 ;
        int endcol = cols -1 ;

        while (startrow <= endrow && startcol <= endcol) {

            for(int i = startcol ; i < endcol ; i++){
                resultList.add(values [startrow][i]);
            }
            startrow++ ;

            for(int i = startrow ; i <= endrow ; i++){
                resultList.add(values[i][endcol]);
            }
            endcol-- ;

            if (startrow <= endrow) {
                for(int i = endcol ; i >= startcol ; i--){
                    resultList.add(values[endrow][i]);
                }
            }
            endrow-- ;

            if (startcol <= endcol) {
                for(int i = endrow ; i >= startrow ; i--){
                    resultList.add(values[i][startcol]);;
                }
            }
            startcol++ ;

            //  .هر کد های بالا به ترتیب کد هایی برای حرکت به راست پایین چپ و بالا است
            
            int[] result = new int[resultList.size()];
            for(int i = 0 ; i < resultList.size() ; i++){
                result[i] = resultList.get(i);
            }
            return result;
        }
        return null;

    }

    /*
        integer partitioning is a combinatorics problem in discreet maths
        the problem is to generate sum numbers which their summation is the input number

        e.g. 1 -> all partitions of integer 3 are:
        3
        2, 1
        1, 1, 1

        e.g. 2 -> for number 4 goes as:
        4
        3, 1
        2, 2
        2, 1, 1
        1, 1, 1, 1

        note: as you can see in examples, we want to generate distinct summations, which means 1, 2 and 2, 1 are no different
        you should generate all partitions of the input number and

        hint: you can measure the size and order of arrays by finding the pattern of partitions and their number
        trust me, that one's fun and easy :)

        if you're familiar with lists and arraylists, you can also edit method's body to use them instead of array
    */
    public static int[][] intPartitions(int n) {

        List<List<Integer>> partitionsList = new ArrayList<>();
        partitionHelper(n, n, new ArrayList<>(), partitionsList);

        int[][] partitionsArray = new int[partitionsList.size()][];
        for (int i = 0; i < partitionsList.size(); i++) {
            List<Integer> partition = partitionsList.get(i);
            partitionsArray[i] = new int[partition.size()];
            for (int j = 0; j < partition.size(); j++) {
                partitionsArray[i][j] = partition.get(j);
            }
        }
        return partitionsArray;
    }

    private static void partitionHelper(int n, int max, List<Integer> currentPartition, List<List<Integer>> partitions) {
        if (n == 0) {
            partitions.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int i = Math.min(max, n); i >= 1; i--) {
            currentPartition.add(i);
            partitionHelper(n - i, i, currentPartition, partitions);
            currentPartition.remove(currentPartition.size() - 1);
        }
    }

}

    public static void main(String[] args) {

        int[] array = {1,2,3,4};
        int targetvalue = 8 ;
        int[] result = productIndices(array , targetvalue);

        if (result != null) {
            System.out.println("index : " + Arrays.toString(result));

        }
        else
        {
            System.out.println("we do not find it .");
        }
    }


    //   main چک کردن کد دوم در 

    int[][] matrix = { {1,2,3},{4,5,6},{7,8,9} };

    int rows = matrix.length ;
    int cols = matrix[0].length ;

    int[] testing = spiralTraversal(matrix , rows , cols);

     for(int i = 0 ; i < testing.length ; i++){
        System.out.print(testing[i] + " ");
    }

    // main چک کردن کد سوم در 

    int number = 4;
        int[][] result = intPartitions(number);

        System.out.println("Partitions of " + number + ":");
        for (int[] partition : result) {
            System.out.print("[");
            for (int i = 0; i < partition.length; i++) {
                System.out.print(partition[i]);
                if (i < partition.length - 1) 
                {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    } 
