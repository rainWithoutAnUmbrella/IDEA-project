package Arrayutil;

public class Util {
    public static void displayNums(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int num : nums) {
            sb.append(" ").append(num);
        }
        sb.append(" ]");
    }
}
