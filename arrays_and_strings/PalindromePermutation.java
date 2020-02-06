import java.util.*;
import java.io.*;

public class PalindromePermutation {
  private boolean check(String testStr) {

    return true;
  }

  public static void main(String[] args) {
    PalindromePermutation tester = new PalindromePermutation();

    HashMap<String, Boolean> testCases = new HashMap<String, Boolean>();

    testCases.put("Tact Cao", true);
    testCases.put("aaaa", true);
    testCases.put("aaab", false);
    testCases.put("aaaab", true);

    for(String key : testCases.keySet()) {
      boolean expected = testCases.get(key);
      if (expected != tester.check(key)) {
        System.out.println("Failed on " + key);
      }
    }
  }
}
