import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());

        treeSet.stream()
                .sorted()
                .collect(Collectors.toList());

        Arrays.stream(new int[3])
                .boxed()
                .sorted((n1, n2) -> Integer.compare(n1, n2))
                .mapToInt(i -> i)
                .toArray();

        StringBuilder sb = new StringBuilder();
        sb.append("0123456789");
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb.toString());

        List<Integer> list = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Set<Integer> set = new HashSet<>();

    }
}
