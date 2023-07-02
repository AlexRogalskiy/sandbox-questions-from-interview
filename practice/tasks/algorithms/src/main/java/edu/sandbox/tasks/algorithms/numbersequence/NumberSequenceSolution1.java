package edu.sandbox.tasks.algorithms.numbersequence;

/*
 * Дан упорядоченный массив натуральных чисел,
 * повторяющихся элементов в списке нет.
 * Нужно преобразовать в строку с перечислением интервалов через запятую.
 *
 * Пример:
 * [2, 3, 5, 6, 7, 8, 9, 11, 20, 21, 22, 25] -> "2-3,5-9,11,20-22"
 */
// TODO: refactor solution, write comment and write unit test
public class NumberSequenceSolution1 {

    public static String joinIntervals(int[] nums) {
        var result = new StringBuilder();
        var isSequenceStarted = true;
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            if (isSequenceStarted) {
                result.append(currentNumber);
            }
            if (i + 1 < nums.length) {
                int nextNumber = nums[i + 1];
                if (nextNumber - currentNumber == 1) {
                    isSequenceStarted = false;
                    continue;
                } else {
                    if (!isSequenceStarted) {
                        result.append("-").append(currentNumber);
                    }
                    isSequenceStarted = true;
                    result.append(",");
                }
            } else {
                if (!isSequenceStarted) {
                    result.append("-").append(nums[i]);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 6, 7, 8, 9, 11, 20, 21, 22};
        System.out.println(joinIntervals(nums));
    }
}
