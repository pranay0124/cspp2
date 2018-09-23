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
	private TreeMap<String, Integer> dict = new TreeMap<>();
	String s1 = "";
	String s2 = "";
	double ans;

	public Distance(File inputFile1, File inputFile2) {
		String line;
		try {
			FileReader filereader = new FileReader(inputFile1);
			BufferedReader bufferedreader = new BufferedReader(filereader);

			while ((line = bufferedreader.readLine()) != null) {
				s1 += line;
			}
			filereader = new FileReader(inputFile2);
			bufferedreader = new BufferedReader(filereader);

			while ((line = bufferedreader.readLine()) != null) {
				s2 += line;
			}

			String lcs = "";
			for (int i = 0; i < s2.length(); i++) {
				for (int j = i + 1 ; j <= s2.length(); j++) {
					if (s1.contains(s2.substring(i, j))) {
						if (s2.substring(i, j).length() > lcs.length()) {
							lcs = s2.substring(i, j);
						}
					}
				}
			}

			if (inputFile1.getName().equals(inputFile2.getName())) {
				ans = 100;
			} else {
				int numerator = lcs.length() * 2 * 100;
				int denominator = s1.length() + s2.length();
				ans = Math.round((numerator / denominator));
			}
			System.out.format("%13.1f", ans);

		} catch (Exception e) {
			System.out.println("No Input");
		}
	}
	public double getSimilarity() {
		return ans;
	}
}