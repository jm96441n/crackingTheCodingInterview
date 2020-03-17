import java.util.*;
import java.io.*;

class Node<T> {
  private T value;
  private Node next;

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

  public void appendList(LinkedList<T> list) {
    Node <T> node = this.getHead();
    while (node.getNext() != null) {
      node = node.getNext();
    }

    node.setNext(list.getHead());
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
}

public class Intersection {

}
