package additions_in_array_forms;

import java.util.Arrays;

public class Main {
    public static final int TEN = 10;
    public static final int ONE = 1;

    public static void main(String[] args) {
        int[] a = {9, 9, 9};
        int[] b = {1};

        boolean increaseArray = false;
        int aLength = a.length;
        int bLength = b.length;
        int biggestArray = Math.max(aLength, bLength);

        int[] buffer1 = new int[biggestArray]; // меньший массив, но того же размера
        int[] buffer2; // больший массив
        if (aLength > bLength) {
            buffer2 = fillingSmallerArray(a, b, aLength, bLength, buffer1);
        } else if (aLength < bLength) {
            buffer2 = fillingSmallerArray(b, a, bLength, aLength, buffer1);
        } else {
            buffer1 = a;
            buffer2 = b;
            System.out.println(Arrays.toString(buffer1));
            System.out.println(Arrays.toString(buffer2));
        }
        int[] result;
        int[] resultBuffer = new int[biggestArray];
        boolean plusTen = false;
        for (int i = 0; i < biggestArray; i++) {
            resultBuffer[biggestArray - 1 - i] = buffer1[biggestArray - 1 - i] + buffer2[biggestArray - 1 - i];
            if (plusTen) {
                resultBuffer[biggestArray - 1 - i]++;
            }
            if (resultBuffer[0] >= TEN) {
                increaseArray = true;
            }
            if (resultBuffer[biggestArray - 1 - i] >= TEN) {
                resultBuffer[biggestArray - 1 - i] -= TEN;
                plusTen = true;
            } else {
                plusTen = false;
            }
        }
        if (increaseArray) {
            result = new int[biggestArray + 1];
            result[0] = ONE;
            System.arraycopy(resultBuffer, 0, result, 1, biggestArray);
        } else {
            result = resultBuffer;
        }
        System.out.println(Arrays.toString(resultBuffer));
        System.out.println(increaseArray);
        System.out.println(Arrays.toString(result));
    }

    private static int[] fillingSmallerArray(int[] a, int[] b, int aLength, int bLength, int[] buffer1) {
        int[] buffer2;
        buffer2 = a;
        for (int i = 0; i < bLength; i++) {
            buffer1[aLength - 1 - i] = b[bLength - 1 - i];
        }
        System.out.println(Arrays.toString(buffer1));
        System.out.println(Arrays.toString(buffer2));
        return buffer2;
    }
}
