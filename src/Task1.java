import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStages = 0;
        int stageLimit = 0;
        int accum = 0;
        int[] stage;

        numberOfStages = scanner.nextInt();
        stageLimit = scanner.nextInt();
        accum = scanner.nextInt();
        stage = new int[numberOfStages];
        for (int i = 0; i < numberOfStages; i++) {
            stage[i] = scanner.nextInt();
        }

        int numOfAccums = 0;
        int numOfUnite = 0;
        boolean itsGroup;
        ArrayList<Integer> firstStageIG = new ArrayList<Integer>();
        ArrayList<Integer> numOfStagesIG = new ArrayList<Integer>();
        int numOfStagesInGroup;

        for (int i = 0; i < numberOfStages; i++) {
            numOfStagesInGroup = 1;
            itsGroup = false;
            int currStage = stage[i];
            boolean addAccum = false;
            for (int j = 0; j < stageLimit; j++) {
                if (currStage % accum == 0) {
                    numOfAccums += currStage / accum;
                    addAccum = true;
                    i += j;
                    break;
                } else {
                    if (!itsGroup) {
                        firstStageIG.add(i + 1);
                    }
                    numOfStagesInGroup++;
                    currStage += stage[j + 1];
                    itsGroup = true;
                }
            }
            if (!addAccum) {
                numOfAccums += stage[i] / accum;
            }
            if (itsGroup) {
                numOfUnite++;
                numOfStagesIG.add(numOfStagesInGroup);
            }
        }

        int firstStringResult = stupidAccumsResult(stage, accum) - numOfAccums;
        System.out.println(firstStringResult);
        System.out.println(numOfUnite);
        for (int i = 0; i < numOfStagesIG.size(); i++) {
            System.out.print(firstStageIG.get(i) + " " + numOfStagesIG.get(i));
            System.out.println();
        }
    }

    public static int stupidAccumsResult(int[] stage, int accum) {
        int numOfAccums = 0;
        for (int j : stage) {
            numOfAccums += Math.ceil(j / (float) accum);
        }
        return numOfAccums;
    }
}
