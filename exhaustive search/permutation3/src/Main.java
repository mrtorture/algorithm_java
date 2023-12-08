import java.util.Set;
import java.util.HashSet;
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("minimum difference of {{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}}: "
                + main.solution(9, new int[][]{{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}}));
        System.out.println("minimum difference of {{1, 2}, {2, 3}, {3, 4}}: "
                + main.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println("minimum difference of {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}: "
                + main.solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
    }

    private int solution(int n, int[][] edges) {
        int[][] sizes = new int[edges.length][2];
        int index = 0;
        for (int[] edge : edges) {
            Set<int[]> edgeSet = new HashSet<>();
            for (int[] edge2 : edges) {
                if (!edge.equals(edge2)) {
                    edgeSet.add(edge2);
                }
            }

            sizes[index][0] = count(edge[0], edgeSet, n);
            sizes[index][1] = count(edge[1], edgeSet, n);
            index++;
        }

        int min = 100;
        for (int[] size : sizes) {
            int diff;
            if (size[0] > size[1]) {
                diff = size[0] - size[1];
            } else {
                diff = size[1] - size[0];
            }

            if (diff < min) {
                min = diff;
            }
        }

        return min;
    }

    private int count(int node, Set<int[]> edgeSet, int nodeCount) {
        Set<int[]> tmp = new HashSet<>();
        for (int[] edge : edgeSet) {
            if (edge[0] == node || edge[1] == node) {
                tmp.add(edge);
            }
        }

        if (tmp.size() == 0) {
            return 1;
        }

        int sum = 0;
        for (int[] edge : tmp) {
            int nextNode;
            if (edge[0] == node) {
                nextNode = edge[1];
            } else {
                nextNode = edge[0];
            }
            edgeSet.remove(edge);
            sum += count(nextNode, edgeSet, nodeCount);
        }

        return 1 + sum;
    }


}