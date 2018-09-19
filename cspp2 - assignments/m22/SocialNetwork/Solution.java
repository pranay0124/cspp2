import java.util.*;
import java.io.*;
class Solution {
	static TreeMap<String, ArrayList<String>> map = new TreeMap<>();
	public static void main(String[] args) {
		try {
			File file = new File("Testcases_SocialNetwork\\input000.txt");
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				String line = scan.nextLine();
				String[] tokens = line.split(" ");
				switch (tokens[0]) {
				case "Create":
					int num = Integer.parseInt(tokens[1]);
					while (num > 0) {
						String inputline = scan.nextLine();
						inputline = inputline.replace(".", "");
						String[] keys = inputline.split(" is connected to ");
						String[] people = keys[1].split(", ");
						ArrayList<String> network = new ArrayList<String>(Arrays.asList(people));
						map.put(keys[0], network);
						num--;
					}
					break;
				case "getConnections" :
					if (map.containsKey(tokens[1])) {
						ArrayList<String> a = map.get(tokens[1]);
						System.out.println(a);
					} else {
						System.out.println("Not a user in Network");
					}
					break;
				case "addConnections" :
					if (map.containsKey(tokens[2])) {
						if (map.containsKey(tokens[1])) {
							map.get(tokens[1]).add(tokens[2]);
						}
					} else {
						System.out.println("Not a user in Network");
					}
					break;

				case "CommonConnections" :
					if (map.containsKey(tokens[1]) && map.containsKey(tokens[2])) {
						ArrayList<String> answer = new ArrayList<>();
						ArrayList<String> x = map.get(tokens[1]);
						ArrayList<String> y = map.get(tokens[2]);
						for (String tempx : x) {
							for (String tempy : y) {
								if (tempx.equals(tempy)) {
									answer.add(tempx);
								}
							}
						}
						System.out.println(answer);
					}
					break;
				case "Network":
					System.out.println(map);
					break;
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("No input file");
		}
	}
// public static void Connections() {
// 	try {
// 		File file = new File("SocialNetwork.txt");
// 		Scanner scan = new Scanner(file);
// 		while (scan.hasNext()) {
// 			String line = scan.nextLine();
// 			line = line.replace(".","")
// 			String[] tokens = line.split(" is connected to ");
// 			String[] people = tokens[1].split(", ");
// 			System.out.println(people);
// 			ArrayList<String> network = new ArrayList<String>(Arrays.asList(people));
// 			map.put(tokens[0], network);
// 			// if (map.get(tokens[0]) == null) {
// 			// 	map.put(tokens[0], new ArrayList<String>());
// 			// }
// 			// map.get(tokens[0]).add(network);

// 		}
// 	} catch (FileNotFoundException e) {
// 		System.out.println("No File");
// 	}
// }
}
