package edu.exercises.numbers;

public class PrimeNumber {
    public boolean isPrimeSchoolMethod(long n) {
        Boolean res = basePrimeCheck(n);
        if (res != null) return res;
        for (long i = 5; i * i < n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    private Boolean basePrimeCheck(long n) {
        if (n <= 1 || n == 4) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        return null;
    }
}
