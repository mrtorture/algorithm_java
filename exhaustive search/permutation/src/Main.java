import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    private Set<Integer> perm = new HashSet<>();

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("number of prime numbers of 17: " + main.solution("17"));
        System.out.println("number of prime numbers of 011: " + main.solution("011"));
    }

    public int solution(String string) {
        List<String> nums = new ArrayList<String>();
        for (int i = 0; i < string.length(); i++) {
            nums.add(string.substring(i, i + 1));
        }

        perm.clear();
        doPerm("", nums);

        int result = 0;
        for (int num : perm) {
            if (num < 2) {
                continue;
            }

            boolean prime = true;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    prime = false;
                    continue;
                }
            }
            if (!prime) {
                continue;
            }
            result++;
        }
        return result;
    }

    private void doPerm(String target, List<String> list) {
        if (list.size() == 0) {
            return;
        }

        for (String str : list) {
            String numStr = target + str;
            perm.add(Integer.parseInt(numStr));
            List<String> nextList = new ArrayList<>(list);
            nextList.remove(str);
            doPerm(numStr, nextList);
        }
    }



}