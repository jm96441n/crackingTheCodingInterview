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

  public void prepend(T value) {
    Node<T> node = new Node<T>(value);
    node.setNext(this.head);
    this.head = node;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public Node<T> getHead() {
    return this.head;
  }

  @Override
  public String toString() {
    StringBuilder myString = new StringBuilder();
    Node<T> node = this.getHead();
    while (node != null) {
      myString.append(node.getValue());
      myString.append(" -> ");
      node = node.getNext();
    }
    return myString.toString();
  }

  public boolean isPalindrome() {
    boolean isPally = true;
    LinkedList<T> stack = new LinkedList<T>();

    int i = 0;
    Node<T> node = this.getHead();
    while(i < (this.size / 2)) {
      stack.prepend(node.getValue());
      node = node.getNext();
      i++;
    }

    if (this.size % 2 != 0) {
      node = node.getNext(); 
    }

    Node<T> stackNode = stack.getHead();

    while(node != null) {
      if (stackNode.getValue() != node.getValue()) {
        isPally = false;
        break;
      } else {
        node = node.getNext();
        stackNode = stackNode.getNext();
      }
    }

    return isPally;
  }
}

public class Palindrome {
  public static void main(String[] args) {
    LinkedList<Integer> testCase1 = new LinkedList<Integer>();
    LinkedList<Integer> testCase2 = new LinkedList<Integer>();
    LinkedList<Integer> testCase3 = new LinkedList<Integer>();
    LinkedList<Integer> testCase4 = new LinkedList<Integer>();

    HashMap<LinkedList<Integer>, Boolean> testCases = new HashMap<LinkedList<Integer>, Boolean>();

    for(int i = 0; i < 10; i++) {
      testCase1.append(i);
      testCase3.append(i);
      testCase4.append(i);
      if (i != 5) {
        testCase2.append(i);
      }
    }

    testCase4.append(10);

    for(int i = 9; i >= 0; i--) {
      testCase1.append(i);
      testCase2.append(i);
      testCase4.append(i);
      if (i != 7) {
        testCase3.append(i);
      }
    }

    testCases.put(testCase1, true);
    testCases.put(testCase2, false);
    testCases.put(testCase3, false);
    testCases.put(testCase4, true);

    for(Map.Entry<LinkedList<Integer>, Boolean> testCase : testCases.entrySet()) {
      boolean returnValue = testCase.getValue();
      LinkedList<Integer> list = testCase.getKey();

      boolean actualValue = list.isPalindrome();
      if (returnValue == actualValue) {
        System.out.println("PASSED");
      } else {
        System.out.println("FAILED");
      }
    }
  }
}
