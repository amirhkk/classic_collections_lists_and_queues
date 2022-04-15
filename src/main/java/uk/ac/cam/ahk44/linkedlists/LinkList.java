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

public class LinkList implements OopList {

  private static class Node{
    private Object value;
    private Node next;

    public Node(Object value, Node next) {
      this.value = value;
      this.next = next;
    }

    Node(Object value) {
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

    public int length() {
      if(next == null){
        return 0;
      }
      return next.length() + 1;
    }
  }

  private Node head;

  LinkList() {
    this.head = null;
  }

  public void addFirst(Object element) {
    if (head == null) {
      head = new Node(element);
    } else {
      head = new Node(element, head);
    }
  }

  public Object removeFirst() {
    if (head == null) {
      throw new NoSuchElementException();
    } else {
      Object ans = head.value;
      head = head.next;
      return ans;
    }
  }

  @Override
  public void reverse() {
    LinkList Amir = new LinkList();
    while(true){
      if(head != null){
        Amir.addFirst(head.value);
        head = head.next;
      }
      else break;
    }
    head = Amir.head;
  }

  public Object get(int n){
    if (head == null) throw new NoSuchElementException();
    if(n == 0) return head.value;
    head = head.next;
    return get(n - 1);
  }

  public int length(){
    if (head == null) return 0;
    return head.length() + 1;
  }

  public static LinkList create(Object[] elements){
    LinkList Amir = new LinkList();
    for(int i = elements.length - 1; i >= 0; i--) Amir.addFirst(elements[i]);
    return Amir;
  }

  public void reorderLowHigh(){
    LinkList Amir = new LinkList();
    int tmp = 1;
    while(true){
      tmp = 1 - tmp;
      if(head != null){
        if(Amir.length() > 0){
          int prev = (int) Amir.removeFirst();
          int now = (int) this.removeFirst();
          if ((now < prev && tmp == 0) || (now > prev && tmp == 1)) {
            Amir.addFirst(prev);
            Amir.addFirst(now);
          } else {
            Amir.addFirst(now);
            Amir.addFirst(prev);
          }
        } else{
          int now = (int) this.removeFirst();
          Amir.addFirst(now);
        }
      }
      else break;
    }
    Amir.reverse();
    head = Amir.head;
  }

  @Override
  public String toString() {
    return String.format("[%s]", head == null ? "" : head.toString());
  }
}
