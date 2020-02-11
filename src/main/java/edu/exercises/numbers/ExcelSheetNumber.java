package edu.exercises.numbers;

public class ExcelSheetNumber {
    private static int RADIX = 26;

    public String toSheetTitle(int n) {
        StringBuilder buf = new StringBuilder();
        while (n > 0) {
            n--;
            buf.append((char) (n % RADIX + 'A'));
            n /= RADIX;
        }
        return buf.reverse().toString();
    }

    public int toNumber(String sheetTitle) {
        int l = sheetTitle.length();
        int num = 0;
        for (int i = 0; i < l; i++) {
            num += ((sheetTitle.charAt(i) - 'A' + 1) * Math.pow(RADIX, l - i - 1));
        }
        return num;
    }
}
