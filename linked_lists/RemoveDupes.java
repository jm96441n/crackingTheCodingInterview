import java.util.*;
import java.io.*;

class Node<T> {
  private T value;
  private Node<T> next;

  public Node(T value) {
    setValue(value);
  }

  private void setValue(T value) {
    this.value = value;
  }

  public T getValue() {
    return this.value;
  }

  public void setNext(Node<T> node) {
    this.next = node;
  }

  public Node<T> getNext() {
    return this.next;
  }
}

class LinkedList<T extends Comparable<T>> implements Comparable<LinkedList<T>> {
  private Node<T> head;
  private Node<T> tail;
  private int size = 0;

  public LinkedList() {}

  public void append(T value) {
    Node<T> node = new Node<T>(value);

    if (isEmpty()) {
      this.head = node;
      this.tail = node;
    } else if (this.tail == this.head) {
      this.head.setNext(node);
      this.tail = node;
    } else {
      this.tail.setNext(node);
      this.tail = node;
    }
    this.size++;
  }

  public int compareTo(LinkedList<T> otherList) {
    int equal = 0;
    if(this.getSize() != otherList.getSize()) {
      equal = 1;
      return equal;
    }

    Node<T> thisHead = getHead();
    Node<T> otherHead = otherList.getHead();
    while(thisHead != null && otherHead != null) {
      if (thisHead.getValue() != otherHead.getValue()) {
        equal = 1;
        break;
      }
      thisHead = thisHead.getNext();
      otherHead = otherHead.getNext();
    }
    return equal;
  }

  public void remove(Node<T> removableNode, Node<T> prevNode) {
    prevNode.setNext(removableNode.getNext());
    removableNode.setNext(null);
    this.size--;
  }

  public Node<T> getHead() {
    return this.head;
  }

  public Node<T> getTail() {
    return this.tail;
  }

  private boolean isEmpty() {
    return this.head == null;
  }

  public int getSize() {
    return this.size;
  }
}

public class RemoveDupes {
  public void removeDupes(LinkedList<Integer> list) {
    // go through the list, when you encounter a new value put it in a hashmap
    // when you encounter a value you've already seen, remove it
    Node<Integer> prevNode = list.getHead();
    Node<Integer> curNode = prevNode.getNext();
    HashMap<Integer, Boolean> seenValues = new HashMap<Integer, Boolean>();
    seenValues.put(prevNode.getValue(), true);

    while(curNode != null) {
      if (seenValues.containsKey(curNode.getValue())) {
        list.remove(curNode, prevNode);
        curNode = prevNode.getNext();
      } else {
        seenValues.put(curNode.getValue(), true);
        prevNode = curNode;
        curNode = curNode.getNext();
      }
    }
  }

  public static void main(String[] args) {
    RemoveDupes checker = new RemoveDupes();
    LinkedList<Integer> testCase = new LinkedList<Integer>();
    LinkedList<Integer> expectedResult = new LinkedList<Integer>();

    for(int i = 0; i < 10; i++) {
      testCase.append(i);
      expectedResult.append(i);
      if (i > 0) {
        testCase.append(9 % i);
      }
    }

    for(int i = 0; i < 10; i++) {
      testCase.append(i);
    }

    checker.removeDupes(testCase);

    if (expectedResult.compareTo(testCase) == 0) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED"); 
    }
  }
}
