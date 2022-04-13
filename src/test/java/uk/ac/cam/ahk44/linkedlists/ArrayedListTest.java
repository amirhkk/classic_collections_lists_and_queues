package uk.ac.cam.ahk44.linkedlists;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ArrayedListTest {


    @Test
    public void ArrayedList_toStringIsEmptyList_whenListEmpty() {
        // ARRANGE
        ArrayedList empty = new ArrayedList();

        // ACT
        String value = empty.toString();

        // ASSERT
        assertThat(value).isEqualTo("[]");
    }

    @Test
    public void ArrayedList_toStringIsSingleItem_whenListContainsOneItem() {
        // ARRANGE
        ArrayedList list = new ArrayedList();
        list.addFirst(1);

        // ACT
        String value = list.toString();

        // ASSERT
        assertThat(value).isEqualTo("[1]");
    }

    @Test
    public void ArrayedList_toStringIsTwoThenOne_whenListHasOneThenTwoAdded() {
        // ARRANGE
        ArrayedList list = new ArrayedList();
        list.addFirst(1);
        list.addFirst(2);

        // ACT
        String value = list.toString();

        // ASSERT
        assertThat(value).isEqualTo("[2,1]");
    }

    @Test
    public void create_IsCorrect(){
        //ARRANGE
        Object[] a = {};
        Object b[] = {1, 2, 3};

        //ACT
        ArrayedList aa = ArrayedList.create(a);
        String p = aa.toString();
        ArrayedList bb = ArrayedList.create(b);
        String q = bb.toString();

        // ASSERT
        assertThat(p).isEqualTo("[]");
        assertThat(q).isEqualTo("[1,2,3]");
    }

    @Test
    public void removeFirst_IsCorrect(){
        // ARRANGE
        ArrayedList list = new ArrayedList();
        list.addFirst(1);
        list.addFirst(2);
        list.removeFirst();

        // ACT
        String value = list.toString();

        // ASSERT
        assertThat(value).isEqualTo("[1]");
    }

    @Test
    public void get_IsCorrect(){
        // ARRANGE
        ArrayedList list = new ArrayedList();
        list.addFirst("!");
        list.addFirst("@");
        list.addFirst("£");

        // ACT
        Object value = list.get(1);

        // ASSERT
        assertThat(value).isEqualTo("@");
    }

    @Test
    public void length_IsCorrect(){
        // ARRANGE
        ArrayedList list = new ArrayedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        // ACT
        int value = list.length();

        // ASSERT
        assertThat(value).isEqualTo(3);
    }

    @Test
    public void reverse_IsCorrect(){
        // ARRANGE
        ArrayedList list = new ArrayedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.reverse();

        // ACT
        String value = list.toString();

        // ASSERT
        assertThat(value).isEqualTo("[1,2,3]");
    }
}
