package sample;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class JavaProb1 {

	@Test
	public void test1() {
		String name = "Applea";
		//System.out.println(strinOccurenceoptimized(name.toLowerCase()));
		System.out.println(strinOccurence(name.toLowerCase()));
	}

	@Test
	public void test2() {
		String name = "westarn";
		System.out.println(strinOccurenceoptimized(name.toLowerCase()));
	}

	@Test
	public void test3() {
		String name = "";
		System.out.println(strinOccurenceoptimized(name.toLowerCase()));
	}

	@Test
	public void test4() {
		String name = "as3434";
		System.out.println(strinOccurenceoptimized(name.toLowerCase()));
	}

	@Test
	public void test5() {
		String name = "ora  nge";
		System.out.println(strinOccurenceoptimized(name.toLowerCase()));
	}

	private Map<Character, Integer> strinOccurenceoptimized(String strone) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < strone.length(); i++) {
			map.put(strone.charAt(i), 
			map.getOrDefault(strone.charAt(i), 0) + 1);
		}
		return map;
	}

	private Map<Character, Integer> strinOccurence(String strone) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int count = 0;
		for (int i = 0; i < strone.length(); i++) {
			if (map.containsKey(strone.charAt(i))) {
				count = map.get(strone.charAt(i));
				map.put(strone.charAt(i), count + 1);
			} else {
				map.put(strone.charAt(i), 1);
			}

		}
		return map;
	}
}
