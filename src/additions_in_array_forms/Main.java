package additions_in_array_forms;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = {9, 4, 3};
        int[] b = {6, 8, 8};

        boolean increaseArray = false;
        int aLength = a.length;
        int bLength = b.length;
        int smallerArray = Math.min(aLength, bLength);
        int biggestArray = Math.max(aLength, bLength);

        int[] buffer1 = new int[biggestArray]; // был меньший стал такой же и перенес значения
        int[] buffer2 = new int[biggestArray];
        if (aLength > bLength) {
            buffer2 = a;
            for (int i = 0; i < bLength; i++) {
                buffer1[aLength - 1 - i] = b[bLength - 1 - i];
            }
            System.out.println(Arrays.toString(buffer1));
            System.out.println(Arrays.toString(buffer2));
        } else if (aLength < bLength) {
            buffer2 = b;
            for (int i = 0; i < aLength; i++) {
                buffer1[bLength - 1 - i] = a[aLength - 1 - i];
            }
            System.out.println(Arrays.toString(buffer1));
            System.out.println(Arrays.toString(buffer2));
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
            if (resultBuffer[0] >= 10) {
                increaseArray = true;
            }
            if (resultBuffer[biggestArray - 1 - i] >= 10) {
                resultBuffer[biggestArray - 1 - i] -= 10;
                plusTen = true;
            } else {
                plusTen = false;
            }
        }
        System.out.println(Arrays.toString(resultBuffer));
        System.out.println(increaseArray);
    }
}
