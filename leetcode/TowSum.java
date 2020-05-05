import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guoyongkui
 */
public class TowSum {


    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum1(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int next = target - nums[i];
            if (map.containsKey(next)){
                return new int[] {map.get(next), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }


    public static int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }

        for (int i=0; i<nums.length; i++){
            int next = target - nums[i];
            if (map.containsKey(next) && map.get(next) != i){
                return new int[] {map.get(next), i};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }

}