package touchsoft.task.register;

import org.junit.Test;

import static org.junit.Assert.*;

public class getNumberTest{

     @Test
    public void getNumber() {
        Recorder recorder = new Recorder();
        String[] actualString = {"06:00 06:01","08:00 08:01","08:00 08:01"};
        int actual = recorder.getNumber(recorder.Processing(actualString));
        int expected = 2;
        assertEquals(actual, expected);
    }
}