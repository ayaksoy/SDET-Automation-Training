package NeotechCoding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSumProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        // Extract the nums array and target value
        String[] parts = input.split("], target = ");
        String numsPart = parts[0].replace("nums = [", "").trim();
        int target = Integer.parseInt(parts[1].trim());

        // Convert the nums part to an integer array
        int[] nums = Arrays.stream(numsPart.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        // Find and print the result
        int[] result = twoSum(nums, target);
        System.out.println("Result: " + Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> list = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            if(list.containsKey(target - nums[i]))
                return new int[]{list.get(target - nums[i]),i};
            list.put(nums[i],i);
        }
        return nums;
    }
}
