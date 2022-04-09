import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'longestCommonSubsequence' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> longestCommonSubsequence(List<Integer> a, List<Integer> b) {
        // Write your code here
        int n = a.size();
        int m = b.size();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i < n+1; i++){
            dp[i][0]  = 0;
        }

        for(int j = 0; j < m+1; j++){
            dp[0][j] = 0;
        }

        for(int i =1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){

                if(a.get(i-1)==b.get(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max( dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int i = n, j = m;

        while(i >0 && j >0){

            if(a.get(i-1) == b.get(j-1)){
                res.add(a.get(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]> dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }

        Collections.reverse(res);
        return res;


    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.longestCommonSubsequence(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
