package edu.coursera.algs41;

import java.util.Arrays;
import java.util.Objects;

public class DetectArrayPermutation {
    public boolean isPermuted(Object[] a, Object[] b) {
        if (a.length != b.length) return false;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            if (!Objects.equals(a[i], b[i])) return false;
        }
        return true;
    }
}
