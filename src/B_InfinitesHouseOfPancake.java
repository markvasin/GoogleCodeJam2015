import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Mvsmark on 4/11/2015.
 */
public class B_InfinitesHouseOfPancake {

    public static int solve(ArrayList<Integer> arr, int index) {

        if (Collections.max(arr) < 4) {
            return index + Collections.max(arr);
        }
        else {
            int max = Collections.max(arr);
            int dividedVal = max - max/2;
            int countval = 0;

            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) > dividedVal && arr.get(i) != arr.indexOf(new Integer(max)))
                    countval++;
            }


            if (dividedVal > countval) {
                arr.remove(new Integer(max));
                arr.add(max/2);
                arr.add(max - max/2);
                return solve(arr, ++index);
            }
            else {
                for (int i = 0; i < arr.size(); i++) {
                    arr.set(i, arr.get(i) - 1);
                }
                return solve(arr, ++index);
            }
        }

    }


    public static void main(String[] args) {
        InputReader input = new InputReader(System.in);
        OutputWriter output = new OutputWriter(System.out);

        int t = input.readInt();
        for (int i = 0; i < t; i++) {
            int n = input.readInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                arr.add(input.readInt());
            }
            output.printLine("Case #" + (i+1) + ": " + solve(arr, 0));
        }

        output.flush();
        output.close();

    }
}
