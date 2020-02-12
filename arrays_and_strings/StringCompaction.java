import java.util.*;
import java.io.*;

public class StringCompaction {
  public String compactString(String uncompacted) {
    int i, letterCount;
    char currentLetter = uncompacted.charAt(0);
    StringBuilder compacted = new StringBuilder();
    letterCount = 0;

    for(i = 0; i < uncompacted.length(); i++) {
      if (uncompacted.charAt(i) == currentLetter) {
        letterCount++;
      } else {
        appendTo(compacted, currentLetter, letterCount);
        currentLetter = uncompacted.charAt(i);
        letterCount = 1;
      }
    }

    appendTo(compacted, currentLetter, letterCount);

    return compacted.length() < uncompacted.length() ? compacted.toString() : uncompacted;
  }

  private void appendTo(StringBuilder string, char letter, int count) {
    string.append(letter);
    string.append(count);
    return;
  }

  public static void main(String[] args) {
    StringCompaction checker = new StringCompaction();

    HashMap<String, String> testCases = new HashMap<String, String>();

    testCases.put("aabcccccaaa", "a2b1c5a3");
    testCases.put("abcdef", "abcdef");
    testCases.put("a", "a");
    testCases.put("abbcdde", "abbcdde");
    testCases.put("abbbcdde", "abbbcdde");
    for(Map.Entry<String, String> testCase : testCases.entrySet()) {
      String actualResult = checker.compactString(testCase.getKey());
      String expectedResult = testCase.getValue();
      if (actualResult.equals(expectedResult)) {
        System.out.println("PASSED on:\n\tInput: " + testCase.getKey() + "\n\tExpected Output: " + expectedResult + "\n\tActual Output: " + actualResult);
      } else {
        System.out.println("FAILED on:\n\tInput: " + testCase.getKey() + "\n\tOutput: " + expectedResult + "\n\tActual Output: " + actualResult);
      }
    }
  }
}
