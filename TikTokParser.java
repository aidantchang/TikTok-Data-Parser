/*Written by Aidan Chang
 * Work In Progress
 * */

import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class TikTokParser {
  public static void main(String[] args) {    
    Scanner scnr = new Scanner(System.in); //for input into console
    
    System.out.print("Please enter two dates to search for videos in the form MM-DD: ");
    String firstDate = scnr.next();
    String secondDate = scnr.next();
    watchHistorySearcher(firstDate, secondDate);
  }
  
  public static void watchHistorySearcher(String firstDate, String secondDate) {
    int counter = 0;
    
    try {
      File history = new File("Video Browsing History.txt");
      Scanner scnr = new Scanner(history); //only for this file, closes afterwards
      while (scnr.hasNextLine()) {
        String currLine = scnr.nextLine();
        
        if (currLine.contains(firstDate) || currLine.contains(secondDate)) {
          counter++;
          String dateTime = currLine.substring(11,22);
          String date = dateTime.substring(0,5);
          String time = timePrinter(dateTime.substring(6,7));
          System.out.println(date + " " + time); //only date and time
          
          String linkLine = scnr.nextLine();
          System.out.println(linkLine.substring(12,68) + "\n"); //prints just link with blank line after
        }
      }
      scnr.close();
    }
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
    System.out.println("Number of links: " + counter);
  }
  
  //method recieves time in military time(HH:MM) and returns in normal time(AM/PM)
  public static String timePrinter(String mTime) {
    //compares hour, if hour comes before 12 prints whole time in AM
    if (mTime.substring(0,2).compareTo("12") == -1) {
      return (mTime + " AM");
    }
    else {
      switch (mTime.substring(0,2)) {
        case "12":
          return (mTime + " PM");
        case "13":
          return ("01" + mTime.substring(2,5) + " PM");
        case "14":
          return ("02" + mTime.substring(2,5) + " PM");
        case "15":
          return ("03" + mTime.substring(2,5) + " PM");
        case "16":
          return ("04" + mTime.substring(2,5) + " PM");
        case "17":
          return ("05" + mTime.substring(2,5) + " PM");
        case "18":
          return ("06" + mTime.substring(2,5) + " PM");
        case "19":
          return ("07" + mTime.substring(2,5) + " PM");
        case "20":
          return ("08" + mTime.substring(2,5) + " PM");
        case "21":
          return ("09" + mTime.substring(2,5) + " PM");
        case "22":
          return ("10" + mTime.substring(2,5) + " PM");
        case "23":
          return ("11" + mTime.substring(2,5) + " PM");
        default:
          return ("input invalid");
      }
    }
  }
  
}