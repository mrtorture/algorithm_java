import java.util.List;
import java.util.ArrayList;

public class Main {
    private final String[] chars = {"A", "E", "I", "O", "U"};
    private final List<String> dict = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("in dictionary index + 1 of AAAAE: " +
                main.solution("AAAAE"));
        System.out.println("in dictionary index + 1 of AAAE: " +
                main.solution("AAAE"));
        System.out.println("in dictionary index + 1 of I: " +
                main.solution("I"));
        System.out.println("in dictionary index + 1 of EIO: " +
                main.solution("EIO"));
    }

    private int solution(String word) {
        dict.clear();
        makeWords(5, "");

        return dict.indexOf(word) + 1;
    }

    private void makeWords(int length, String prefix) {
        if (length < 1) {
            return;
        }

        for (String char1 : chars) {
            String newWord = prefix + char1;
            dict.add(newWord);
            makeWords(length - 1, newWord);
        }
    }
}