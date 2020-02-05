import java.io.*;
import java.util.*;

public class IsUnique {
  private boolean isUniqueUsingHashMap(String testCase) {
    HashMap<Character, Integer> frequencies = new HashMap<Character, Integer>();
    boolean unique = true;
    for(int i = 0; i < testCase.length(); i++) {
      if (frequencies.containsKey(testCase.charAt(i))) {
        unique = false;
        break;
      } else {
        frequencies.put(testCase.charAt(i), 1);
      }
    }
    return unique;
  }

  public static void main(String[] args) {
    IsUnique checker = new IsUnique();
    ArrayList<String> testCases = new ArrayList<String>();
    testCases.add("first");
    testCases.add("second");
    testCases.add("aabbccdd");
    testCases.add("abcabcabc");

    for(String testCase : testCases) {
      if (checker.isUniqueUsingHashMap(testCase)) {
        System.out.println("HM: String is unique: " + testCase);
      } else {
        System.out.println("HM: String is not unique: " + testCase);
      }
    }
  }
}
