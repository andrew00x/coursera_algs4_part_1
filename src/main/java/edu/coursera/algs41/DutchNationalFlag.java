package edu.coursera.algs41;

import static edu.coursera.algs41.Util.swap;

public class DutchNationalFlag {
    public enum Pebble {
        RED("r"), WHITE("w"), BLUE("b");

        private final String v;

        Pebble(String v) {
            this.v = v;
        }

        public String toString() {
            return v;
        }
    }

    public void dutchNationalFlag(Pebble[] pebbles) {
        int l, h, i;
        i = l = 0;
        h = pebbles.length - 1;
        while (i <= h) {
            Pebble p = pebbles[i];
            if (p == Pebble.RED) {
                swap(pebbles, i++, l++);
            } else if (p == Pebble.BLUE) {
                swap(pebbles, i, h--);
            } else {
                i++;
            }
        }
    }
}
