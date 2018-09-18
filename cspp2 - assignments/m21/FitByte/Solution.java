import java.util.*;
import java.io.*;

class Food {
	private String nameOfFood;
	private String quantity;
	private String time;

	Food(final String nameOfFood, final String quantity, final String time) {
		this.nameOfFood = nameOfFood;
		this.quantity = quantity;
		this.time = time;
	}

	public String getnameOfFood() {
		return nameOfFood;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getTime() {
		return time;
	}
}
//==============================================================================================//
class Water {
	private String quantity;
	private String time;

	Water(final String quantity, final String time) {
		this.quantity = quantity;
		this.time = time;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getTime() {
		return time;
	}
}
//==============================================================================================//
class PhysicalActivity {
	private String nameOfActivity;
	private String startTime;
	private String endTime;
	private String notes;

	PhysicalActivity(final String nameOfActivity, final String startTime, final String endTime, final String notes) {
		this.nameOfActivity = nameOfActivity;
		this.startTime = startTime;
		this.endTime = endTime;
		this.notes = notes;
	}

	PhysicalActivity(final String nameOfActivity, final String startTime, final String endTime) {
		this.nameOfActivity = nameOfActivity;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getnameOfActivity() {
		return nameOfActivity;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getNotes() {
		return notes;
	}
}
//==============================================================================================//
class Weight {
	private String kilograms;
	private String fat;
	private String time;

	Weight(final String kilograms, final String fat, final String time) {
		this.kilograms = kilograms;
		this.fat = fat;
		this.time = time;
	}

	public String getKilograms() {
		return kilograms;
	}

	public String getFat() {
		return fat;
	}

	public String getTime() {
		return time;
	}
}
//==============================================================================================//
class Sleep {
	private String dateStartTime;
	private String dateEndTime;

	Sleep(final String dateStartTime, final String dateEndTime) {
		this.dateStartTime = dateStartTime;
		this.dateEndTime = dateEndTime;
	}

	public String getdateStartTime() {
		return dateStartTime;
	}

	public String getdateEndTime() {
		return dateEndTime;
	}
}
//==============================================================================================//
class DayLog {
	private ArrayList<Food> foodList = new ArrayList<Food>();
	private ArrayList<Water> waterList = new ArrayList<Water>();
	private ArrayList<PhysicalActivity> activityList = new ArrayList<PhysicalActivity>();
	private ArrayList<Weight> weightList = new ArrayList<Weight>();
	private ArrayList<Sleep> sleepList = new ArrayList<Sleep>();

	private String date;

	DayLog(final String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void addFood(String food) {
		String[] food1 = food.split(",");
		Food foodObj = new Food(food1[0], food1[1], food1[2]);
		foodList.add(foodObj);
	}

	public void addWater(String water) {
		String[] water1 = water.split(",");
		Water waterObj = new Water(water1[0], water1[1]);
		waterList.add(waterObj);
	}

	public void addActivity(String activity) {
		String[] activity1 = activity.split(",");
		PhysicalActivity activityObj = new PhysicalActivity(activity1[0], activity1[1], activity1[2], activity1[3]);
		activityList.add(activityObj);
	}

	public void addWeight(String weight) {
		String[] weight1 = weight.split(",");
		Weight weightObj = new Weight(weight1[0], weight1[1], weight1[2]);
		weightList.add(weightObj);
	}

	public void addSleep(String sleep) {
		String[] sleep1 = sleep.split(",");
		Sleep sleepObj = new Sleep(sleep1[0], sleep1[1]);
		sleepList.add(sleepObj);
	}

	public void foodLog() {
		System.out.println("Food");
		if (foodList.size() == 0) System.out.println("None");
		for (int i = 0; i < foodList.size(); i++) {
			System.out.println("Date:" + date);
			System.out.println("Time:" + foodList.get(i).getTime());
			System.out.println("Name:" + foodList.get(i).getnameOfFood());
			System.out.println("Quantity:" + foodList.get(i).getQuantity());
		}
	}

	public void waterLog() {
		System.out.println("Water");
		if (waterList.size() == 0) System.out.println("None");
		for (int i = 0; i < waterList.size(); i++) {
			System.out.println("Date:" + date);
			System.out.println("Quantity:" + waterList.get(i).getQuantity());
		}
	}
	public void activityLog() {
		System.out.println("PhysicalActivity");
		if (activityList.size() == 0) System.out.println("None");
		for (int i = 0; i < activityList.size(); i++) {
			System.out.println("Name" + activityList.get(i).getnameOfActivity());
			System.out.println("Notes" + activityList.get(i).getNotes());
			System.out.println("Date:" + date);
			System.out.println("Starttime: " + activityList.get(i).getStartTime());
			System.out.println("Endtime: " + activityList.get(i).getEndTime());
		}
	}
	public void weightLog() {
		System.out.println("Weight");
		if (weightList.size() == 0) System.out.println("None");
		for (int i = 0; i < weightList.size(); i++) {
			System.out.println("Date:" + date);
			System.out.println("Time:" + weightList.get(i).getTime());
			System.out.println("Weight:" + weightList.get(i).getKilograms());
			System.out.println("Fat:" + weightList.get(i).getFat());
		}
	}
	public void sleepLog() {
		System.out.println("Sleep");
		if (sleepList.size() == 0) System.out.println("None");
		for (int i = 0; i < sleepList.size(); i++) {
			System.out.println("Date:" + date);
			System.out.println("Starttime:" + sleepList.get(i).getdateStartTime());
			System.out.println("Endtime:" + sleepList.get(i).getdateEndTime());
		}
	}


	public void printLog() {
		foodLog();
		waterLog();
		activityLog();
		weightLog();
		sleepLog();
	}
}
//==============================================================================================//
class Solution {
	static ArrayList<DayLog> daylog = new ArrayList<DayLog>();
	//String[] logDate = new String[3];
	public static void main(String[] args) {
		try {
			File file = new File("input.txt");
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				String line = scan.nextLine();
				String[] tokens = line.split(" ");
				String key = null;
				int flag1 = 0;
				String date = tokens[1];
				DayLog currentday = null;
				int flag = 0;
				for (int i = 0; i < daylog.size(); i++) {
					if (date.equals(daylog.get(i).getDate())) {
						currentday = daylog.get(i);
						flag = 1;
					}
				}
				if (daylog.size() == 0 || flag == 0) {
					DayLog day = new DayLog(date);
					daylog.add(day);
					currentday = day;
				}

				switch (tokens[0]) {
				case "food" :
					currentday.addFood(tokens[2]);
					break;
				case "water" :
					currentday.addWater(tokens[2]);
					break;
				case "activity" :
					currentday.addActivity(tokens[2]);
					break;
				case "weight" :
					currentday.addWeight(tokens[2]);
					break;
				case "sleep" :
					currentday.addSleep(tokens[2]);
					break;
				case "foodLog":
					currentday.foodLog();
					System.out.println();
					break;
				case "waterLog":
					currentday.waterLog();
					System.out.println();
					break;
				case "activityLog":
					currentday.activityLog();
					System.out.println();
					break;
				case "sleepLog":
					currentday.sleepLog();
					System.out.println();
					break;
				case "weightLog":
					currentday.weightLog();
					System.out.println();
					break;
				case "print" :
					currentday.printLog();
					break;

				}

			}
		} catch (IOException io) {
			System.out.println("File not found");
		}
	}
}