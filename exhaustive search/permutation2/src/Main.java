import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
public class Main {
    private final Set<Integer> nums = new HashSet<>();
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("strength: 80, dungeons: {{80,20},{50,40},{30,10}}, how many dungeons: " +
                main.solution(80, new int[][]{{80,20},{50,40},{30,10}}));
    }

    private int solution(int k, int[][] dungeons) {
        List<Integer[]> dungeonList = new ArrayList<>();
        for (int[] dungeon : dungeons) {
            Integer[] tmp = new Integer[2];
            tmp[0] = dungeon[0];
            tmp[1] = dungeon[1];
            dungeonList.add(tmp);
        }

        nums.clear();
        explore(k, dungeonList, dungeonList.size());

        int max = 0;
        for (Integer num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private void explore(int k, List<Integer[]> dungeonList, int length) {
        int available = 0;
        for (Integer[] dungeon : dungeonList) {
            if (k >= dungeon[0]) {
                available++;
            }
        }

        if (available == 0) {
            nums.add(length - dungeonList.size());
            return;
        }

        for (Integer[] dungeon : dungeonList) {
            if (k < dungeon[0]) {
                continue;
            }
            List<Integer[]> newList = new ArrayList<>(dungeonList);
            newList.remove(dungeon);
            explore(k - dungeon[1], newList, length);
        }
    }
}