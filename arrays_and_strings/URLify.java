import java.util.*;
import java.io.*;

public class URLify {
  private char[] replaceSpaces(char[] testArr, int strlen) {
    int countOfSpaces = countChar(testArr, 0, strlen, ' ');
    int newIndex = (strlen - 1) + (countOfSpaces * 2);
    int oldIndex = strlen - 1;
    for (; newIndex >= oldIndex && oldIndex > 0; newIndex--) {
      if (testArr[oldIndex] == ' ') {
        testArr[newIndex] = '0';
        newIndex--;
        testArr[newIndex] = '2';
        newIndex--;
        testArr[newIndex] = '%';
        oldIndex--;
      } else {
        testArr[newIndex] = testArr[oldIndex];
        oldIndex--;
      }
    }
    return testArr;
  }

  private int countChar(char[] testArr, int start, int end, char matcher) {
    int count = 0;

    for(int i = start; i < end; i++) {
      if (testArr[i] == matcher) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    URLify checker = new URLify();

    char[] expectedArr, actualArr, testArr;
    ArrayList<String> testCases = new ArrayList<String>();
    ArrayList<String> expected = new ArrayList<String>();

    testArr = "Mr John Smith    ".toCharArray();
    expectedArr = "Mr%20John%20Smith".toCharArray();
    actualArr = checker.replaceSpaces(testArr, 13);

    if(actualArr.equals(expectedArr)) {
      System.out.println("Failed on:\n" + new String(testArr) + "\n" + new String(actualArr));
    }

    testArr = "Hello".toCharArray();
    expectedArr = "Hello".toCharArray();
    actualArr = checker.replaceSpaces(testArr, 5);

    if(actualArr.equals(expectedArr)) {
      System.out.println("Failed on:\n" + new String(testArr) + "\n" + new String(actualArr));
    }

    testArr = "This is a test      ".toCharArray();
    expectedArr = "This%20is%20a%20test".toCharArray();
    actualArr = checker.replaceSpaces(testArr, 5);

    if(actualArr.equals(expectedArr)) {
      System.out.println("Failed on:\n" + new String(testArr) + "\n" + new String(actualArr));
    }
  }
}
