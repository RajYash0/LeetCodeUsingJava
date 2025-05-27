import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup solution = new SubsetsWithDup();
        int[] nums = {1, 2, 2};
        List<List<Integer>> output = solution.subsetsWithDup(nums);
        for (List<Integer> subset : output) {
            System.out.println(subset);
        }
    }
}
