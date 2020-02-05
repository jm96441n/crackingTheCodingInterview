import java.io.*;
import java.util.*;

public class CheckPermutation {
  /*
   * Time complexity = O(n) where n is the length of the strings, as we have to iterate
   * through each string separately
   *
   * Space Complexity is O(n^2) where n is the length of the strings, as we are storing an
   * an additional copy of the first string in the hash map
  */
  private boolean isPermutation(String test1, String test2) {
    int i;
    HashMap<Character, Integer> characters = new HashMap<Character, Integer>();
    boolean permutation = true;

    if (test1.length() != test2.length()) {
      permutation = false;
      return permutation;
    }

    for (i = 0; i < test1.length(); i++) {
      characters.put(test1.charAt(i), 1);
    }

    for (i = 0; i < test2.length(); i++) {
      if(!characters.containsKey(test2.charAt(i))) {
        permutation = false;
        break;
      }
    }

    return permutation;
  }

  public static void main(String[] args) {
    CheckPermutation checker = new CheckPermutation();
    ArrayList<String> testCases1 = new ArrayList<String>();
    ArrayList<String> testCases2 = new ArrayList<String>();

    testCases1.add("abcd");
    testCases2.add("badc");

    testCases1.add("abcd");
    testCases2.add("efgh");

    testCases1.add("abcd");
    testCases2.add("bbcd");

    testCases1.add("abcdefghijklmnop");
    testCases2.add("ponmlkjihgfedcb");

    for(int i = 0; i < testCases1.size(); i++) {
      if(checker.isPermutation(testCases1.get(i), testCases2.get(i))) {
        System.out.println("These strings are permutations: " + testCases1.get(i) + " " + testCases2.get(i));
      } else {
        System.out.println("These strings are NOT permutations: " + testCases1.get(i) + " " + testCases2.get(i));
      }
    }
  }
}
