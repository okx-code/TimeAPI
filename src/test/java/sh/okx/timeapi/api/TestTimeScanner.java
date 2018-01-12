package sh.okx.timeapi.api;

import org.junit.Test;
import sh.okx.timeapi.api.TimeScanner;

import static org.junit.Assert.*;

public class TestTimeScanner {
    @Test
    public void testTimeScanner() {
        TimeScanner timeScanner = new TimeScanner("1aaa2bbb3");

        assertEquals(timeScanner.nextLong(), 1);
        assertEquals(timeScanner.nextString(), "aaa");
        assertEquals(timeScanner.nextLong(), 2);
        assertEquals(timeScanner.nextString(), "bbb");
        assertEquals(timeScanner.nextLong(), 3);
    }
}
