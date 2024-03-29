/*
Given an array of integers numbers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.

You may assume that each input would have exactly one solution and you may not use the same element twice.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
*/

class TwoSumSortedArray.
{

    public int[] twoSum(int[] numbers, int target) {

        int len = numbers.length;
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map.put(numbers[i], i);
        }

        for (int i = 0; i < len; i++) {
            int val = target - numbers[i];
            if (map.get(val) != null) {
                result = new int[] { i + 1, map.get(val) + 1 };
                break;
            }
        }

        return result;

    }
}