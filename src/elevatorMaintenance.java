import java.util.ArrayList;

public class elevatorMaintenance {
    public static int[] solution(int area) {
        int sum = area;
        ArrayList<Integer> arr = new ArrayList();
        while (sum != 0) {
            int item = (int) Math.sqrt(sum);
            arr.add((int) Math.pow(item, 2));
            sum = sum - ((int) Math.pow(item, 2));
        }
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}
