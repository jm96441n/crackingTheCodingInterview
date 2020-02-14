import java.util.*;
import java.io.*;

class Node<T> {
  private T value;
  private Node<T> next;

  public Node(T value) {
    this.value = value;
  }

  public T getValue() {
    return this.value;
  }

  public Node<T> getNext() {
    return this.next;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }
}

class LinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size = 0;

  public LinkedList() {}

  public void append(T value) {
    Node<T> node = new Node<T>(value);

    if (isEmpty()) {
      this.head = node;
      this.tail = node;
    } else {
      this.tail.setNext(node);
      this.tail = node;
    }
    this.size++;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public T kthElementFromEnd(int k) {
    Node<T> frontNode = this.head;
    int i;

    for(i = 0; i < k; i++) {
      frontNode = frontNode.getNext();      
    }

    Node<T> valueNode = this.head;

    while(frontNode != null) {
      frontNode = frontNode.getNext();
      valueNode = valueNode.getNext();
    }

    return valueNode.getValue();
  }
}

public class KthElement<T> {
  public static void main(String[] args) {
    LinkedList<Integer> testIntegers = new LinkedList<Integer>();
    LinkedList<String> testStrings = new LinkedList<String>();

    for(int i = 1; i < 100; i++) {
      testIntegers.append(i);
      testStrings.append(Integer.toString(i));
    }

    HashMap<Integer, Integer> testCases = new HashMap<Integer, Integer>();

    testCases.put(15, 85);
    testCases.put(5, 95);
    testCases.put(97, 3);
    testCases.put(99, 1);
    testCases.put(30, 70);

    for(Map.Entry<Integer, Integer> testCase : testCases.entrySet()) {
      int arg = testCase.getKey();

      int expectedIntResult = testCase.getValue();
      String expectedStringResult = Integer.toString(expectedIntResult);

      int actualIntResult = testIntegers.kthElementFromEnd(arg);
      String actualStringResult = testStrings.kthElementFromEnd(arg);

      if (expectedIntResult == actualIntResult) {
        System.out.println("PASSED INTEGER:\n\tArg: " + arg + "\n\tResult: " + actualIntResult + "\n\tExpected: " + expectedIntResult); 
      } else {
        System.out.println("FAILED INTEGER:\n\tArg: " + arg + "\n\tResult: " + actualIntResult + "\n\tExpected: " + expectedIntResult); 
      }

      if (expectedStringResult.equals(actualStringResult)) {
        System.out.println("PASSED STRING:\n\tArg: " + arg + "\n\tResult: " + actualStringResult + "\n\tExpected: " + expectedStringResult); 
      } else {
        System.out.println("FAILED STRING:\n\tArg: " + arg + "\n\tResult: " + actualStringResult + "\n\tExpected: " + expectedStringResult); 
      }

      System.out.println();
      System.out.println();
    }
  }
}
