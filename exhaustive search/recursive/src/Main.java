import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        SimpleNums simpleNums = new SimpleNums();

        simpleNums.setMax(10000);

        for (int i = 1; i <= 10000; i++) {
            simpleNums.makeNum(i);
        }

        simpleNums.print();
    }

    private static class SimpleNums {
        private final Set<Integer> simpleNums = new HashSet<>();

        private void setMax(int max) {
            for (int i = 1; i <= max; i++) {
                simpleNums.add(i);
            }
        }

        private void print() {
            for (Integer num : simpleNums) {
                System.out.println(num);
            }
        }

        private void makeNum(int input) {
            int num = input;
            num += makeSum(input);

            if (num > 10000) {
                return;
            }
            if (simpleNums.remove(num)) {
                return;
            }

            makeNum(num);
        }

        private int makeSum(int input) {
            if (input <= 0) {
                return 0;
            }

            int quo = input / 10;
            int rem = input % 10;

            return rem + makeSum(quo);
        }
    }
}