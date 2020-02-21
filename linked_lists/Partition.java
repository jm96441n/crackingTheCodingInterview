import java.io.*;
import java.util.*;
class Node {
  private int value;
  private Node next;

  public Node(int value) {
    this.value = value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  public Node getNext() {
    return this.next;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}

class LinkedList {
  private Node head;
  private Node tail;
  private int size = 0;

  public LinkedList() {}

  public void append(int value) {
    Node node = new Node(value);

    if (isEmpty()) {
      this.head = node;
      this.tail = node;
    } else {
      this.tail.setNext(node);
      this.tail = node;
    }
    this.size++;
  }

  public void appendList(LinkedList list) {
    this.getTail().setNext(list.getHead());
    this.tail = list.getTail();
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  private int getSize() {
    return this.size;
  }

  public Node getHead() {
    return this.head;
  }

  public Node getTail() {
    return this.tail;
  }

  @Override
  public String toString() {
    StringBuilder myString = new StringBuilder();
    Node node = this.getHead();
    while (node != null) {
      myString.append(node.getValue());
      myString.append(" -> ");
      node = node.getNext();
    }
    return myString.toString();
  }

  public LinkedList partition (int value) {
    LinkedList greaterList = new LinkedList();
    LinkedList lessThanList = new LinkedList();
    Node node = this.getHead();

    while (node != null) {
      if (node.getValue() >= value) {
        greaterList.append(node.getValue());
      } else {
        lessThanList.append(node.getValue());
      }
      node = node.getNext();
    }

    if (lessThanList.isEmpty()) {
      return greaterList;
    } else if (greaterList.isEmpty()) {
      return lessThanList;
    } else {
      lessThanList.appendList(greaterList);
      return lessThanList;
    }
  }
}

public class Partition {
  public static void main(String[] args) {
    LinkedList myList = new LinkedList();
    myList.append(2);
    myList.append(25);
    myList.append(1);
    myList.append(-15);
    myList.append(400);
    myList.append(4);
    myList.append(9);
    myList.append(151515155);
    myList.append(10);
    myList.append(3);

    LinkedList partitioned = myList.partition(251515155);
    System.out.println(myList.toString());
    System.out.println(partitioned.toString());
  }
}
