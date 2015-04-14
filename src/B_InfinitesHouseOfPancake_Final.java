import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Mvsmark on 4/14/2015.
 */
public class B_InfinitesHouseOfPancake_Final {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tc = input.nextInt();
        for (int i = 0; i < tc; i++) {
            int n = input.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                arr.add(input.nextInt());
            }
            int sol = solve(arr);
            System.out.println("Case #" + (i+1) + ": " + sol);
        }

    }

    public static int solve(ArrayList<Integer> P){
        int max_pancakes = Collections.max(P);
        int ret = max_pancakes;
        for (int x = 1; x < max_pancakes; x++) {
            int total_moves = 0;
            for (Integer Pi: P) {
                total_moves += (Pi - 1) / x;
            }
            ret = Math.min(ret, total_moves + x);
        }
        return ret;
    }
}
