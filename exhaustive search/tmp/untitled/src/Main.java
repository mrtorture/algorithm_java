import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.toArray(new Integer[0]);

        String str = "joejoe";
        int result = 1 << 3;

        System.out.println("1 << 3: " + result);

        int result2 = 9 & result;
        System.out.println("9 & 1 << 3: " + result2);
    }
}