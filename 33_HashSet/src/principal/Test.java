package principal;

import java.util.HashSet;

public class Test {

	public static void main(String[] args) {
		HashSet<Integer> nums = new HashSet<>();
		nums.add(100);
		nums.add(200);
		nums.add(300);
		nums.add(400);
		nums.add(200);
		nums.remove(400);
		for (Integer n:nums) {
			System.out.println(n);
		}
	}
}