import java.util.*;
import java.io.*;

public class OneAway {
  private boolean isOneAway(char[] string1, char[] string2) {
    boolean oneAway = true;
    boolean foundOneDifferent = false;
    boolean[] visited = new boolean[string2.length];

    for(char c : string1) {
      boolean found = false;
      for(int i = 0; i < string2.length; i++) {
        if (c == string2[i] && !visited[i]) {
          visited[i] = true;
          found = true;
          break;
        }
      }
      if (!found && foundOneDifferent) {
        oneAway = false;
        break;
      } else if(!found) {
        foundOneDifferent = true;
      }
    }

    return oneAway;
  }

  public static void main(String[] args) {
    OneAway checker = new OneAway();

    if (checker.isOneAway("pale".toCharArray(), "ple".toCharArray())) {
      System.out.println("PASSED: pale, ple");
    } else {
      System.out.println("FAILED: pale, ple");
    }

    if (checker.isOneAway("pales".toCharArray(), "pale".toCharArray())) {
      System.out.println("PASSED: pales, pale");
    } else {
      System.out.println("FAILED: pales, pale");
    }

    if (checker.isOneAway("pale".toCharArray(), "bale".toCharArray())) {
      System.out.println("PASSED: pale, bale");
    } else {
      System.out.println("FAILED: pale, bale");
    }

    if (checker.isOneAway("pale".toCharArray(), "bake".toCharArray())) {
      System.out.println("FAILED: pale, bake");
    } else {
      System.out.println("PASSED: pale, bake");
    }

    if (checker.isOneAway("pape".toCharArray(), "pae".toCharArray())) {
      System.out.println("PASSED: pape, pae");
    } else {
      System.out.println("FAILED: pape, pae");
    }

    if (checker.isOneAway("pape".toCharArray(), "pal".toCharArray())) {
      System.out.println("FAILED: pape, pal");
    } else {
      System.out.println("PASSED: pape, pal");
    }
  }
}
