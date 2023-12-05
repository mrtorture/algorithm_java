import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] sol1 = {1, 2, 3, 4, 5};
        int[] result1 = main.solution(sol1);
        System.out.print("maximum matching of 1, 2, 3, 4, 5:");
        for (int num : result1) {
            System.out.print(" " + num);
        }
        System.out.println();
        int[] sol2 = {1, 3, 2, 4, 2};
        int[] result2 = main.solution(sol2);
        System.out.print("maximum matching of 1, 3, 2, 4, 2:");
        for (int num : result2) {
            System.out.print(" " + num);
        }
        System.out.println();
    }

    public int[] solution(int[] correct) {
        int[] student1 = new int[correct.length];
        for (int i = 0; i < student1.length; i++){
            student1[i] = i % 5 + 1;
        }

        int[] student2 = new int[correct.length];
        for (int i = 0; i < student2.length; i++) {
            if (i % 2 == 0) {
                student2[i] = 2;
            } else {
                switch (i % 8 / 2) {
                    case 0:
                        student2[i] = 1;
                        break;
                    case 1:
                        student2[i] = 3;
                        break;
                    case 2:
                        student2[i] = 4;
                        break;
                    default:
                        student2[i] = 5;
                }
            }
        }

        int[] student3 = new int[correct.length];
        for (int i = 0; i < student3.length; i++) {
            switch (i % 10 / 2) {
                case 0:
                    student3[i] = 3;
                    break;
                case 1:
                    student3[i] = 1;
                    break;
                case 2:
                    student3[i] = 2;
                    break;
                case 3:
                    student3[i] = 4;
                    break;
                default:
                    student3[i] = 5;
            }
        }

        int[] count = new int[3];
        for (int i = 0; i < correct.length; i++) {
            if (student1[i] == correct[i]) {
                count[0]++;
            }
            if (student2[i] == correct[i]) {
                count[1]++;
            }
            if (student3[i] == correct[i]) {
                count[2]++;
            }
        }

        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (count[i] == max) {
                resultList.add(i + 1);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

}