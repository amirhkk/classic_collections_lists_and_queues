package uk.ac.cam.ahk44.linkedlists;

import java.util.NoSuchElementException;

public class ArrayedList implements OopList{

    private static Object[] arr;
    private static int len;

    ArrayedList() {
        this.len = 0;
        arr = new Object[1];
    }

    public void addFirst(Object element) {
        if(len < arr.length){
            for(int i = len; i > 0; i--){
                arr[i] = arr[i - 1];
            }
        }
        else{
            Object[] arr2 = new Object[arr.length * 2];
            for(int i = 1; i <= len; i++){
                arr2[i] = arr[i - 1];
            }
            arr = arr2;
        }
        len += 1;
        arr[0] = element;
    }

    public Object removeFirst() {
        if (arr[0] == null) {
            throw new NoSuchElementException();
        } else {
            Object ans = arr[0];
            len -= 1;
            for(int i = 0; i < len; i++){
                arr[i] = arr[i + 1];
            }
            return ans;
        }
    }

    public Object get(int n){
        if (n >= len) throw new NoSuchElementException();
        return arr[n];
    }

    public int length(){ return len;}

    public static ArrayedList create(Object[] elements){
        ArrayedList Amir = new ArrayedList();
        for(int i = elements.length - 1; i >= 0; i--) Amir.addFirst(elements[i]);
        return Amir;
    }

    @Override
    public String toString() {
        String ans = "";
        for(int i = 0; i < len - 1; i++) ans = ans + arr[i].toString() + ",";
        if(len > 0) ans += arr[len - 1];
        return String.format("[%s]", ans);
    }
}
