package A;

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

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public String next() {
        return readString();
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

    public void flush() {
        writer.flush();
    }

}

class IOUtils {

    public static int[] readIntArray(InputReader in, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = in.readInt();
        return array;
    }

}
