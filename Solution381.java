import java.util.*;

class RandomizedCollection {
    List<Integer> nums;
    Map<Integer, Set<Integer>> map;
    Random rand;

    public RandomizedCollection() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean notPresent = !map.containsKey(val) || map.get(val).isEmpty();
        map.computeIfAbsent(val, k -> new HashSet<>()).add(nums.size());
        nums.add(val);
        return notPresent;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) return false;
        int removeIdx = map.get(val).iterator().next();
        map.get(val).remove(removeIdx);
        int lastVal = nums.get(nums.size() - 1);
        nums.set(removeIdx, lastVal);
        map.get(lastVal).add(removeIdx);
        map.get(lastVal).remove(nums.size() - 1);
        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
