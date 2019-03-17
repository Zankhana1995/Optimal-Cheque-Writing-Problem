package com.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem {

	public static int r = 3;
	public static int amount = 97;
	public static int balance = 6;

	private static List<List<Integer>> combinations(List<Integer> list, int maxLength) {
		return combinations(list, maxLength, new ArrayList(), new ArrayList());
	}

	private static List<List<Integer>> combinations(List<Integer> list, int length, List<Integer> current,
			List<List<Integer>> result) {
		if (length == 0) {
			List<List<Integer>> newResult = new ArrayList<>(result);
			newResult.add(current);
			return newResult;
		}

		List<List<List<Integer>>> res3 = new ArrayList<>();
		for (Integer i : list) {
			List<Integer> newCurrent = new ArrayList<>(current);
			newCurrent.add(i);
			res3.add(combinations(list, length - 1, newCurrent, result));
		}

		List<List<Integer>> res2 = new ArrayList<>();
		for (List<List<Integer>> lst : res3) {
			res2.addAll(lst);
		}
		return res2;
	}

	public static void printCombinations(List<Integer> list, int maxLength, Map<Integer, Integer> map) {
		List<List<Integer>> combs = combinations(list, maxLength);
		int cost = Integer.MAX_VALUE;
		String finalLine = "";
		for (List<Integer> lst : combs) {
			Integer sum = 0;
			String line = "";
			int period = 0;
			List<Integer> li = new ArrayList<>();
			for (Integer i : lst) {
				sum = sum + i;
				if (((sum - amount * (period + 1)) <= balance) && sum >= amount * (period + 1)) {
					line = line + " " + i;
					li.add(i);
				}
				period++;
			}
			if (li.size() == r && sum == amount * r) {
				int costSum = 0;
				for (Integer integer : li) {
					costSum += map.get(integer);
				}
				if (costSum < cost) {
					cost = costSum;
				
					finalLine = line;
				}
			}
		}
		System.out.println(finalLine + " " + "cost :" + cost);
	}

	public static void main(String[] args) throws IOException {

		List<Integer> list = new ArrayList<>();
		File file = new File("E:\\GithubRepo\\Optimal-Cheque-Writing-Problem\\cost.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		Map<Integer, Integer> map = new HashMap<>();
		while ((st = br.readLine()) != null) {
			String[] values = st.split("\\s+");
			map.put(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
		}
		list.add(amount);
		for (int i = 1; i <= balance; i++) {
			list.add(amount + i);
		}
		for (int i = 1; i <= balance; i++) {
			list.add(amount - i);
		}
		printCombinations(list, r, map);
		br.close();
	}
}
