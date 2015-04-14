import java.util.Scanner;

/**
 * Created by Mvsmark on 4/14/2015.
 */
public class A_StandingOvation_Final {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tc = input.nextInt();
        for (int i = 0; i < tc ; i++) {
            int smax = input.nextInt();
            int t = 0;
            String s = input.next();
            int min_invite = 0;
            for (int j = 0; j < smax + 1; j++) {
                min_invite = Math.max(min_invite, j - t);
                t += s.charAt(j) - '0';
            }
            System.out.println("Case #" + (i+1) + ": " + min_invite);
        }
    }
}
