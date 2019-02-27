package task.register;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void Main() {
        Recorder recorder = new Recorder();
        List<Date> list = recorder.processing(recorder.load("input.txt"));
        int actual = recorder.numberOfEmployees(list);
        int expected = 4;
        System.out.println("Number: " + actual);
        System.out.println("Expected number: " + expected);
        assertEquals(actual, expected);
    }
}