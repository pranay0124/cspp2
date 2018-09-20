/**
 ******************************************************************************
 *                    HOMEWORK, 15-121
 ******************************************************************************
 *                  THE DOCUMENT DISTANCE
 ******************************************************************************
 *
 * The document distance problem is the problem of computing the distance
 * between two given text documents.
 *
 * The distance between two documents is the angle between their word
 * frequency vectors.
 *
 *
 *****************************************************************************/

import java.util.*;
import java.io.*;
import java.net.*;

public class Distance {
	//requirements are defined by provided tests
	//       Test1.java, Test2.java, Test3.java, Test4.java
	TreeMap<String, Integer> dict = new TreeMap<>();
	private int numOfLines;
	private int numOfWords;
	private int numOfDistinctWords;
	private double dotproduct;
	private double norm;

	// public Distance(String input) {
	// 	String[] lines = input.split("\n");
	// 	numOfLines = lines.length;
	// 	for (String line : lines) {
	// 		String[] words = line.split(" ");
	// 		numOfWords = 0;
	// 		for (String word : words) {
	// 			if (dict.containsKey(word.toLowerCase())) {
	// 				int a = dict.get(word.toLowerCase());
	// 				a ++;
	// 				dict.put(word.toLowerCase(), a);
	// 				numOfWords ++;
	// 			} else {
	// 				dict.put(word.toLowerCase(), 1);
	// 				numOfWords ++;
	// 			}
	// 		}
	// 	}
	// 	numOfDistinctWords = dict.size();
	// }

	public Distance(File inputfile) {
		String line = null;
		try {
			Scanner scan = new Scanner(inputfile);
			while (scan.hasNext()) {
				numOfLines++;
				line = scan.nextLine();
				line = line.replaceAll("[^A-Za-z-0-9 ]", "");
				line = line.replaceAll("\\s", "");
				String[] words = line.toLowerCase().split("\\W");
				for (String word : words) {
					if (dict.containsKey(word)) {
						int a = dict.get(word);
						a++;
						dict.put(word, a);
						numOfWords++;
					} else {
						if (word.length() > 0) {
							dict.put(word, 1);
							numOfWords++;
						}

					}

				}
			}
			numOfDistinctWords = dict.size();
		} catch (Exception e) {
			System.out.println("File not found");
		}
	}

	public int getNumOfLines() {
		return numOfLines;
	}

	public int getNumOfWords() {
		return numOfWords;
	}

	public int getNumOfDistinctWords() {
		return numOfDistinctWords;
	}

	public double norm() {
		double sum = 0;
		for (int value : dict.values()) {
			sum += Math.pow(value, 2);
		}
		norm = Math.sqrt(sum);
		return norm;
	}

	public TreeMap getMap() {
		return dict;
	}

	public double innerProduct(TreeMap dict2) {
		// double dotproduct = 0.0;
		TreeMap<String, Integer> map1 = dict;
		TreeMap<String, Integer> map2 = dict2;

		if (dict.size() < dict2.size()) {
			map1 = dict2;
			map2 = dict;
		}
		for (String keymap1 : map1.keySet()) {
			for (String keymap2 : map2.keySet()) {
				System.out.println(keymap1+ "-----"+ keymap2);
				if (keymap1.equals(keymap2)) {
					dotproduct += map1.get(keymap1) * map2.get(keymap2);
				}
			}
		}
		return dotproduct;
	}

	public double angle(Distance dict3) {
		double numerator = innerProduct(dict3.dict);
		double denominator1 = norm();
		double denominator2 = dict3.norm();
		double calc = numerator / (denominator1 * denominator2);
		double ang = (calc * 100);
		return ang;
	}


}