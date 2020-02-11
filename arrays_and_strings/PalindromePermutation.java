import java.util.*;
import java.io.*;

public class PalindromePermutation {
  private boolean check(String testStr) {
    boolean palindrome = true;
    char[] charArr = testStr.replace(" ", "").toLowerCase().toCharArray();
    HashMap<Character, Integer> charCounts = new HashMap<Character, Integer>();

    for (Character c : charArr) {
      if (charCounts.containsKey(c)) {
        charCounts.put(c, charCounts.get(c) + 1);
      } else {
        charCounts.put(c, 1);
      }
    }

    // if the length of the word is even, then all letters should have an even count
    // else if the length is odd all the letters except one should have an even count
    if (charArr.length % 2 == 0) {
      for(Integer value : charCounts.values()) {
        if (value % 2 != 0) {
          palindrome = false;
          break;
        }
      }
    } else {
      boolean seenOdd = false;
      for(Integer value : charCounts.values()) {
        if (value % 2 != 0 && seenOdd) {
          palindrome = false;
          break;
        } else if (value % 2 != 0) {
          seenOdd = true;
        }
      }
    }

    return palindrome;
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
