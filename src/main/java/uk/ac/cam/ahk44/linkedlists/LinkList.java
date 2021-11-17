/*
 * Copyright 2021 Ben Philps <bp413@cam.ac.uk>, Andrew Rice <acr31@cam.ac.uk>, Amir Kadkhodaei
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.ahk44.linkedlists;

import java.util.NoSuchElementException;

public class LinkList {

  private static class Node {
    private int value;
    private Node next;

    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }

    Node(int value) {
      this.value = value;
      this.next = null;
    }

    @Override
    public String toString() {
      if (next == null) {
        return String.valueOf(value);
      }
      return value + "," + next;
    }
  }

  private Node head;

  LinkList() {
    this.head = null;
  }

  void addFirst(int element) {
    if (head == null) {
      head = new Node(element);
    } else {
      head = new Node(element, head);
    }
  }

  int removeFirst() {
    if (head == null) {
      throw new NoSuchElementException();
    } else {
      int ans = head.value;
      head = head.next;
      return ans;
    }
  }

  int get(int n){
    if (head == null) throw new NoSuchElementException();
    if(n == 0) return head.value;
    removeFirst();
    return get(n - 1);
  }

  int length(){
    if (head == null) return 0;
    removeFirst();
    return length() + 1;
  }

  public static LinkList create(int[] elements){
    LinkList Amir = new LinkList();
    for(int i = 0; i < elements.length; i++) Amir.addFirst(elements[i]);
    return Amir;
  }

  @Override
  public String toString() {
    return String.format("[%s]", head == null ? "" : head.toString());
  }
}
