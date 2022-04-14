package uk.ac.cam.ahk44.linkedlists;

public class LinkQueue {

    private static LinkList one;
    private static LinkList two;

    LinkQueue() {
        one = new LinkList();
        two = new LinkList();
    }

    public void push(Object element){
        one.addFirst(element);
    }

    public Object pop(){
        //System.out.println(two.toString());
        if(two.length() == 0){
            one.reverse();
            two = one;
            one = new LinkList();
        }
        //System.out.println(two.toString());
        return two.removeFirst();
    }
}
