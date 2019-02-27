package touchsoft.task.register;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckTest {

    @Test
    public void check() {
        Recorder recorder = new Recorder();
        String actual = recorder.check("10:00 10:30");
        String expected = "10:00 10:30";
        assertEquals(actual, expected);
    }
}