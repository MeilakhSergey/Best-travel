import java.util.*;

public class SumOfK {
    public static void main(String[] args) {
        System.out.println("****** Basic Tests small numbers******");
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        Integer n = chooseBestSum(163, 3, ts);
        System.out.println(n);   //163
        ts = new ArrayList<>(Arrays.asList(50));
        n = chooseBestSum(163, 3, ts);
        System.out.println(n);   //null*/
        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        n = chooseBestSum(230, 3, ts);
        System.out.println(n);   //228

        ts = new ArrayList<>(Arrays.asList(50, 50, 50));
        n = chooseBestSum(155, 3, ts);
        System.out.println(n);   //228
    }
    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        int n = ls.size();
        Integer max = -1;
        int sum;
        if (k > n)
            return null;

        int[] index = new int[k];
        for (int i = 0; i < k; i++) {
            index[i] = i + 1;
        }
        do {
            sum = 0;
            for (int i = 0; i < k; i++) {
                sum += ls.get(index[i] - 1);
            }
            if (max < sum && sum <= t) max = sum;

        } while ((index = generateCombination(k, n, index)) != null);

        return (max > 0) ? max : null;
    }

    static int[] generateCombination(int k, int n, int[] index) {
        for (int i = k - 1; i >= 0; i--) {
            if (index[i] < n - k + i + 1) {
                index[i]++;
                for (int j = i + 1; j < k; j++) {
                    index[j] = index[j-1] + 1;
                }
                return index;
            }
        }
        return null;
    }
}
