import java.util.*;
import java.util.stream.Collectors;

public class SortExamples {
    public static void main(String[] args) {
//        int[] primitiveInts = new int[]{1, 2, 3};
//        Arrays.sort(primitiveInts);
//
//        TreeSet<Integer> treeSet = new TreeSet<>();
//        treeSet.add(1);
//        treeSet.add(2);
//        treeSet.add(-1);
//        treeSet.add(-2);
//        for (int i : treeSet) {
//            System.out.println(i); // -2부터 출력
//        }
//        System.out.println(treeSet.first()); // -2
//        System.out.println(treeSet.size()); // 4 개수 안 줄어듦
//
//        Collections.sort(new ArrayList()); // list만 정렬 가능...
//
//        List<Integer> collect = treeSet.stream().sorted(null).collect(Collectors.toList());

        List<Node> nodeList = new ArrayList<>();
        Node[] nodeArray = new Node[10];
        Arrays.sort(nodeArray); // Object[] a

        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(-1);
        hashSet.add(-2);
        hashSet.add(4);
        hashSet.add(2);
        List<Integer> collectedHashSet = hashSet.stream().sorted().collect(Collectors.toList()); // 오름차순으로 정렬
        for (int i : collectedHashSet) {
            System.out.println(i);
        }
        // Map.Entry -> getKey, getValue

    }

    static class Node {

    }
}
