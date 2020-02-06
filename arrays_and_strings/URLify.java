import java.util.*;
import java.io.*;

public class URLify {
  private String replaceSpaces(String testCase, int strlen) {
    return testCase;
  }

  public static void main(String[] args) {
    URLify checker = new URLify();

    ArrayList<String> testCases = new ArrayList<String>();
    ArrayList<String> expected = new ArrayList<String>();

    testCases.add("Mr John Smith    ");
    expected.add("Mr%20John%20Smith");

    testCases.add("Hello");
    expected.add("Hello");

    testCases.add("This is a test      ");
    expected.add("This%20is%20a%20test");

    for(int i = 0; i < testCases.size(); i++) {
      int strlen = testCases.get(i).strip().length();
      if(checker.replaceSpaces(testCases.get(i), strlen) != expected.get(i)) {
        System.out.println("Failed on: " + testCases.get(i));
      }
    }
  }
}
