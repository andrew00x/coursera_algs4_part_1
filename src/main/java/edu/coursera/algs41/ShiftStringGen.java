package edu.coursera.algs41;

import edu.princeton.cs.algs4.StdOut;

public class ShiftStringGen {
    public static void main(String[] args) {
        StringBuilder buff = new StringBuilder();
        for (int n = 0; n < args.length; n++) {
            buff.setLength(0);
            String str = args[n];
            buff.append(str);
            buff.append(str);
            int len = str.length();
            for (int i = 0; i < len; i++) StdOut.printf("%s %s\n", str, buff.substring(i, i + len));
        }
    }
}
