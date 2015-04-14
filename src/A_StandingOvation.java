import java.io.*;
import java.util.InputMismatchException;


/**
 * Created by Mvsmark on 4/11/2015.
 */
public class A_StandingOvation {
    public static void main(String[] args) {

        InputReader input = new InputReader(System.in);
        OutputWriter output = new OutputWriter(System.out);

        int t = input.readInt();

        for (int i = 0; i < t; i++) {
            int n = input.readInt();
            String x = input.readString();
            int result = 0;
            int[] prefixsum = new int[x.length() + 1];
            prefixsum[0] = 0;
            for (int j = 1; j < prefixsum.length; j++) {
                prefixsum[j] = prefixsum[j-1] + (x.charAt(j-1) - '0');
            }
            for (int k = 1; k < x.length(); k++) {
                if (k > prefixsum[k] && (x.charAt(k) - '0' > 0 )) {
                    result += k - prefixsum[k];
                    prefixsum[k] += result;
                    for (int l = k+1; l < prefixsum.length; l++) {
                        prefixsum[l] = prefixsum[l-1] + (x.charAt(l-1) - '0');
                    }
                }
            }
            output.printLine("Case #" + (i+1) +": " + result);

        }

        output.flush();
        output.close();

    }
}