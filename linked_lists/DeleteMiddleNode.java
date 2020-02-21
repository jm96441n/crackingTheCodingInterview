import java.io.*;
import java.util.*;
class Node<T> {
  private T value;
  private Node<T> next;

  public Node(T value) {
    this.value = value;
  }

  public void setValue(T value) {
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

class LinkedList<T extends Comparable<T>> implements Comparable<LinkedList<T>>{
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

  private int getSize() {
    return this.size;
  }

  public Node<T> getHead() {
    return this.head;
  }

  public Node<T> kthElement(int k) {
    Node<T> frontNode = this.head;
    int i;

    for(i = 0; i < k; i++) {
      frontNode = frontNode.getNext();      
    }

    return frontNode;
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

  public void deleteNodeAt(Node<T> node) {
    while(node != null) {
      node.setValue(node.getNext().getValue());
      if (node.getNext().getNext() == null) {
        node.setNext(null);
      }
      node = node.getNext();
    }
    this.size--;
  }
}

public class DeleteMiddleNode {
  public static void main(String[] args) {
    LinkedList<Integer> testCase = new LinkedList<Integer>();
    LinkedList<Integer> expected = new LinkedList<Integer>();

    for(int i = 0; i < 15; i++) {
      if (i != 13) {
        expected.append(i);
      }
      testCase.append(i);
    }

    Node<Integer> removalNode = testCase.kthElement(13);

    testCase.deleteNodeAt(removalNode);
    if (expected.compareTo(testCase) == 0) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED"); 
    }
  }
}
