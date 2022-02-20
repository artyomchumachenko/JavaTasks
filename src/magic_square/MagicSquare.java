package magic_square;

import java.util.ArrayList;
import java.util.Arrays;

public class MagicSquare {
    private static final int THREE = 3;

    public static void main(String[] args) {
        ArrayList<Integer> xValues = new ArrayList<>();
        ArrayList<Integer> yValues = new ArrayList<>();
        ArrayList<Integer> zValues = new ArrayList<>();
        int sum = 1;
        if (sum > 27) {
            System.out.println("Сумма больше чем 9+9+9 = 27, условие некорректно");
        }
        for (int x = 0; x <= sum; x++) {
            for (int y = 0; y <= sum; y++) {
                for (int z = 0; z <= sum; z++) {
                    if (x + y + z == sum) {
                        xValues.add(x);
                        yValues.add(y);
                        zValues.add(z);
                    } else if (x + y + z > sum) {
                        break;
                    }
                }
            }
        }
        // Print all variants for curr sum
        System.out.println(xValues);
        System.out.println(yValues);
        System.out.println(zValues);
        System.out.println();

        int[][] currElementOfSquare = new int[THREE][THREE];
        boolean work = true;
        int answer = 0;
        int bufferHighIndex = 0;
        int bufferMiddleIndex = 0;
        int bufferLowIndex = 0;
        int bufferLeftIndex = 0;
        int bufferMiddleToRightIndex = 0;
        int totalNumberOfOptions = xValues.size();

        boolean nextStep1 = false;
        boolean nextStep2 = false;
        boolean nextStep3 = false;

        while (work) {
            currElementOfSquare[0][0] = xValues.get(bufferHighIndex);
            currElementOfSquare[0][1] = yValues.get(bufferHighIndex);
            currElementOfSquare[0][2] = zValues.get(bufferHighIndex);

            if (currElementOfSquare[0][1] == xValues.get(bufferMiddleIndex)) {
                currElementOfSquare[1][1] = yValues.get(bufferMiddleIndex);
                currElementOfSquare[2][1] = zValues.get(bufferMiddleIndex);
                nextStep1 = true;
            } else {
                nextStep1 = false;
            }

            if (nextStep1) {
                if (currElementOfSquare[2][1] == yValues.get(bufferLowIndex)) {
                    currElementOfSquare[2][0] = xValues.get(bufferLowIndex);
                    currElementOfSquare[2][2] = zValues.get(bufferLowIndex);
                    nextStep2 = currElementOfSquare[0][0] + currElementOfSquare[2][0] <= sum &&
                            currElementOfSquare[0][2] + currElementOfSquare[2][2] <= sum;
                } else {
                    nextStep2 = false;
                }
            } else {
                bufferMiddleIndex++;
                bufferLowIndex = 0;
                bufferLeftIndex = 0;
                bufferMiddleToRightIndex = 0;
            }

            if (nextStep2) {
                if (currElementOfSquare[0][0] == xValues.get(bufferLeftIndex) &&
                        currElementOfSquare[2][0] == zValues.get(bufferLeftIndex)) {
                    currElementOfSquare[1][0] = yValues.get(bufferLeftIndex);
                    nextStep3 = true;
                } else {
                    nextStep3 = false;
                }
            } else {
                bufferLowIndex++;
                bufferLeftIndex = 0;
                bufferMiddleToRightIndex = 0;
            }

            if (nextStep3) {
                if (currElementOfSquare[1][0] == xValues.get(bufferMiddleToRightIndex) &&
                        currElementOfSquare[1][1] == yValues.get(bufferMiddleToRightIndex)) {
                    currElementOfSquare[1][2] = zValues.get(bufferMiddleToRightIndex);
//                    System.out.println("bufferMiddleToRightIndex +++");
                    for (int i = 0; i < THREE; i++) {
                        for (int j = 0; j < THREE; j++) {
                            System.out.print(currElementOfSquare[i][j] + "\t");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    answer++;
                    bufferMiddleToRightIndex++;
                } else {
                    bufferMiddleToRightIndex++;
//                    System.out.println("bufferMiddleToRightIndex ---");
                }
            } else {
                bufferLeftIndex++;
                bufferMiddleToRightIndex = 0;
            }

            if(bufferMiddleToRightIndex == totalNumberOfOptions) {
                bufferLeftIndex++;
                bufferMiddleToRightIndex = 0;
            }
            if (bufferLeftIndex == totalNumberOfOptions) {
                bufferLowIndex++;
                bufferLeftIndex = 0;
                bufferMiddleToRightIndex = 0;
            }
            if (bufferLowIndex == totalNumberOfOptions) {
                bufferMiddleIndex++;
                bufferLowIndex = 0;
                bufferLeftIndex = 0;
                bufferMiddleToRightIndex = 0;
            }
            if (bufferMiddleIndex == totalNumberOfOptions) {
                bufferHighIndex++;
                bufferMiddleIndex = 0;
                bufferLowIndex = 0;
                bufferLeftIndex = 0;
                bufferMiddleToRightIndex = 0;
            }
            if (bufferHighIndex == totalNumberOfOptions) {
                work = false;
            }
        }
        System.out.println("Answer = " + answer);
    }
}
