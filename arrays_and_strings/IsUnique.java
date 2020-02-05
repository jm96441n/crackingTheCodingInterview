import java.io.*;
import java.util.*;

public class IsUnique {
  /*
   * Runtime complexity = O(n) because we only have to iterate through the string onces
   * and each hash lookup/insertion is O(1) time
   * Space complexity = O(n^2) because we are essentially duplicating each character in the
   * string when we store it in the hash
  */
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

  private boolean isUniqueNoDS(String testCase) {
    boolean unique = true;

    for(int i = 0; i < testCase.length(); i++) {
      char compare = testCase.charAt(i);
      for(int j = i + 1; j < testCase.length(); j++) {
        if (compare == testCase.charAt(j)) {
          unique = false;
          break;
        }
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

      if (checker.isUniqueNoDS(testCase)) {
        System.out.println("DS: String is unique: " + testCase);
      } else {
        System.out.println("DS: String is not unique: " + testCase);
      }
      System.out.println();
    }
  }
}
