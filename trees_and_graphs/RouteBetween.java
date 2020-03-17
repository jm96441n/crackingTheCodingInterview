import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;

public class RouteBetween {

  private boolean findRoute(ArrayList<Node> visited, Node current, Node end) {
    if (childrenContainsEnd(current.children, end)) {
      return true;
    }

    if (current.children.length == 0 || visitedContainsCurrent(visited, current)) {
      return false;
    }

    visited.add(current);

    boolean found = false;
    for (int i = 0; i < current.children.length; i++) {
      found = findRoute(visited, current.children[i], end);
      if (found) {
        break;
      }
    }
    return found;
  }

  public boolean hasRoute(Node start, Node end) {
    ArrayList<Node> visited = new ArrayList<Node>();
    boolean found = findRoute(visited, start, end);
    return found;
  }

  private boolean childrenContainsEnd(Node[] children, Node end) {
    boolean found = false;
    for (int i = 0; i < children.length; i++) {
      if (children[i] == end) {
        found = true;
        break;
      }
    }
    return found;
  }

  private boolean visitedContainsCurrent(ArrayList<Node> visited, Node current) {
    boolean found = false;
    for (Node node : visited) {
      if (node == current) {
        found = true;
        break;
      }
    }
    return found;

  }

  public static void main(String[] args) {
    Graph withPath = new Graph();
    String[] nodeNames = { "zero", "one", "two", "three", "four", "five" };
    Node[] allNodes = new Node[6];
    for (int i = 0; i < 6; i++) {
      allNodes[i] = new Node();
      allNodes[i].name = nodeNames[i];
    }

    allNodes[0].children = new Node[3];
    allNodes[0].children[0] = allNodes[1];
    allNodes[0].children[1] = allNodes[4];
    allNodes[0].children[2] = allNodes[5];


    allNodes[1].children = new Node[3];
    allNodes[1].children[0] = allNodes[2];
    allNodes[1].children[1] = allNodes[3];
    allNodes[1].children[2] = allNodes[4];

    allNodes[2].children = new Node[1];
    allNodes[2].children[0] = allNodes[1];
    
    allNodes[3].children = new Node[2];
    allNodes[3].children[0] = allNodes[2];
    allNodes[3].children[1] = allNodes[4];
    
    allNodes[4].children = new Node[0];
    allNodes[5].children = new Node[0];

    HashMap<Node[], Boolean> testCases = new HashMap<Node[], Boolean>();

    Node[] testCase1 = { allNodes[0], allNodes[5] };
    testCases.put(testCase1, true);

    Node[] testCase2 = { allNodes[5], allNodes[0] };
    testCases.put(testCase2, false);

    Node[] testCase3 = { allNodes[3], allNodes[0] };
    testCases.put(testCase3, false);

    RouteBetween checker = new RouteBetween();
    for(Map.Entry<Node[], Boolean> testCase : testCases.entrySet()) {
      boolean expectedResult = testCase.getValue();
      Node[] testArgs = testCase.getKey();
      boolean actualResult = checker.hasRoute(testArgs[0], testArgs[1]);
      if (expectedResult == actualResult) {
        System.out.println("PASSED: " + testArgs[0].name + " " + testArgs[1].name);
      } else {
        System.out.println("FAILED: " + testArgs[0].name + " " + testArgs[1].name);
      }
    }
  }
}
