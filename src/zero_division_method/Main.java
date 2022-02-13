package zero_division_method;

public class Main {
    public static final int TEN = 10;

    public static void main(String[] args) {
        double numberIsDividing = 15;
        double numberByWhichWeDivide = 14;

        double sumBuffer = numberByWhichWeDivide;
        boolean integerPartNotFound = true;
        int integerPart = 0;
        do {
            if (numberIsDividing >= sumBuffer) {
                sumBuffer += numberByWhichWeDivide;
                integerPart++;
            } else {
                integerPartNotFound = false;
                sumBuffer = 0;
            }
        } while (integerPartNotFound);
//        System.out.println(integerPart);
        double remainder = numberIsDividing - numberByWhichWeDivide * integerPart;

        double coeffDouble = 0.1;
        double currPlusDouble = 0;
        boolean doublePartNotFound = true;
        int currMarkDouble = 0;
        int disableMarkDoubleSearch = 5;
        double sumOfDoublePart = 0;
        sumBuffer = numberByWhichWeDivide;
        double lastScore = 0;
        remainder *= TEN;
        do {
            if (remainder == numberByWhichWeDivide) {
                doublePartNotFound = false;
                sumOfDoublePart += currPlusDouble;
            } else if (remainder > sumBuffer) {
                lastScore = sumBuffer;
                sumBuffer += numberByWhichWeDivide;
                currPlusDouble += coeffDouble;
            } else {
                remainder = remainder - lastScore;
                sumBuffer = numberByWhichWeDivide;
                sumOfDoublePart += currPlusDouble;
                coeffDouble = coeffDouble * 0.1;
                remainder *= TEN;
                currPlusDouble = 0;
                currMarkDouble++;
            }
        } while (doublePartNotFound && currMarkDouble < disableMarkDoubleSearch);
//        System.out.println(sumOfDoublePart);
        double result = integerPart + sumOfDoublePart;
        System.out.println(result);
        double test = 3.0 / 2;
//        System.out.println(test);
    }
}
