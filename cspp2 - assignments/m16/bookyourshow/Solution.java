/**
 * Author : Pranay Kumar Y.
 * Date : 12th September,2018.
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Class for show.
 */
class Show {
    /**
     * String variable movie.
     */
    private String movie;
    /**
     * String variable ShowTime.
     */
    private String showTime;
    /**
     * String Array for seats.
     */
    private String[] seats;

    /**
     * Constructs the object for show.
     *
     * @param      movie1     The movie 1
     * @param      showTime1  The show time 1
     * @param      seats1     The seats 1
     */
    Show(final String movie1, final String showTime1, final String[] seats1) {
        this.movie = movie1;
        this.showTime = showTime1;
        this.seats = seats1;
    }
    
    /**
     * Gets the movie.
     *
     * @return     The movie.
     */
    String getMovie() {
        return movie;
    }
    
    /**
     * Gets the show time.
     *
     * @return     The show time.
     */
    String getShowTime() {
        return showTime;
    }
    
    /**
     * Gets the seats.
     *
     * @return     The seats.
     */
    String[] getSeats() {
        return seats;
    }
    
    /**
     * Sets the seat na.
     *
     * @param      index  The index
     */
    void setSeatNA(final int index) {
        seats[index] = "N/A";
    }
    
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return movie + "," + showTime;
    }
}

/**
 * Class for patron.
 */
class Patron {
    /**
     * String variable for name.
     */
    private String name;
    /**
     * String variable for mobile.
     */
    private String mobile;
    
    /**
     * Constructs the object patron.
     *
     * @param      name    The name
     * @param      mobile  The mobile
     */
    Patron(final String name1, final String mobile1) {
        this.name = name1;
        this.mobile = mobile1;
    }
    
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    String getName() {
        return name;
    }
    
    /**
     * Gets the mobile.
     *
     * @return     The mobile.
     */
    String getMobile() {
        return mobile;
    }
    
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return name + " " + mobile;
    }

}

class BookYourShow {
    ArrayList<Show> showList;
    ArrayList<String> ticketList;

    BookYourShow() {
        showList = new ArrayList<>();
        ticketList = new ArrayList<>();
    }

    void addAShow(Show show) {
        showList.add(show);
    }

    Show getAShow(String movie, String showTime ) {
        for (Show show : showList) {
            if (show.getMovie().equals(movie) && show.getShowTime().equals(showTime)) {
                return show;
            }
        }
        return null;
    }

    void bookAShow(String movie, String showTime, Patron patron, String[] seats) {
        Show show = getAShow(movie, showTime);
        if (show == null) {
            System.out.println("No show");
            return;
        }
        boolean flag = false;
        String[] sseats = show.getSeats();
        for (String seat : seats) {
            for (int i = 0; i < sseats.length; i++) {
                if (seat.equals(sseats[i])) {
                    show.setSeatNA(i);
                    flag = true;
                }
            }
        }
        if (flag) {
            ticketList.add(patron.getMobile() + " " + movie + " " + showTime);
        }
    }

    void printTicket(String movie, String showTime, String mobile) {
        String t = mobile + " " + movie + " " + showTime;
        // for (String ticket : ticketList) {
        //  if (t.equals(ticket)) {
        //      System.out.println(t);
        //  }
        // }
        if (ticketList.contains(t)) {
            System.out.println(t);
        } else {
            System.out.println("Invalid");
        }
    }

    void showAll() {
        for (Show show : showList) {
            System.out.println(show.getMovie() + "," + show.getShowTime() + "," + Arrays.toString(show.getSeats()).replace(" ", ""));
            //System.out.println(show.toString() + "," + Arrays.toString(show.getSeats()).replace(" ", ""));
        }

    }
}

class Solution {
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                              replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
            case "add":
                int k = 2;
                String[] seats = new String[tokens.length - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

            case "book":
                k = 2 + 2;
                seats = new String[tokens.length - 2 - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.bookAShow(check[1], tokens[1],
                              new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

            case "get":
                Show show = bys.getAShow(check[1], tokens[1]);
                if (show != null) {
                    System.out.println(show);
                } else {
                    System.out.println("No show");
                }
                break;

            case "print":
                bys.printTicket(check[1], tokens[1], tokens[2]);
                break;

            case "showAll":
                bys.showAll();
                break;

            default:
                break;
            }
        }
    }
}
