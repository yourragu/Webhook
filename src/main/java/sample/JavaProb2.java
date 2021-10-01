package sample;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class JavaProb2 {

	@Test
	public void test1() {
		int[] arr1 = { 1, 2, 2, 2, 2, 2, 1, 1 };
		System.out.println(maxElemInArray(arr1));
	}

	@Test
	public void test2() {
		int[] arr1 = { 0, 0, 0, 0, 0, 0, 0, 0 };
		System.out.println(maxElemInArray(arr1));
	}

	@Test
	public void test3() {
		int[] arr1 = { 1, 2, 8, 7, 5, 6, 4, 3 };
		System.out.println(maxElemInArray(arr1));
	}

	private int maxElemInArray(int[] num) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			map.put(num[i], map.getOrDefault(num[i], 0) + 1);
		}
		System.out.println(map);
		for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
			System.out.println(entrySet.getKey()+ " ->" + entrySet.getValue());
			if ((num.length / 2) < entrySet.getValue()) {
				return (entrySet.getKey());
			}
		}
		return -1;
	}

	private int maxElemInArrayoptimized(int[] num) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			map.put(num[i], map.getOrDefault(num[i], 0) + 1);
		}
		System.out.println(map);
		for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
			System.out.println(entrySet.getKey()+ " ->" + entrySet.getValue());
			if ((num.length / 2) < entrySet.getValue()) {
				return (entrySet.getKey());
			}
		}
		return -1;
	}
	
}
