package uk.ac.cam.ahk44.linkedlists;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LinkQueueTest {

    @Test
    public void push_works() {
        // ARRANGE
        LinkQueue list = new LinkQueue();
        list.push(1);
        list.push(2);

        // ACT
        Object value = list.pop();

        // ASSERT
        assertThat(value).isEqualTo(1);

        // ACT
        Object Amir = list.pop();

        // ASSERT
        assertThat(Amir).isEqualTo(2);
    }
}
