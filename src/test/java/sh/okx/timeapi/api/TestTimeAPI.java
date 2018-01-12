package sh.okx.timeapi.api;

import org.junit.Test;
import sh.okx.timeapi.api.TimeAPI;

import static org.junit.Assert.*;

public class TestTimeAPI {
    @Test
    public void testTimeAPI() {
        assertEquals(new TimeAPI("1sec5min2s").getMilliseconds(), 303000, 0.1);
        assertEquals(new TimeAPI("5s, 7d, 9weeks and 22 hours").getSeconds(), 6127205, 0.1);
        assertEquals(new TimeAPI("89 secs, 1 hour 17 days").getMinutes(), 24541.4833, 0.0001);
        assertEquals(new TimeAPI("6d4h3s2m").getHours(), 148.03416, 0.00001);
        assertEquals(new TimeAPI("7h 2m").getDays(), 0.29305, 0.00001);
        assertEquals(new TimeAPI("1 day and 7h").getWeeks(), 0.18452, 0.00001);
        assertEquals(new TimeAPI("1y and 1 mo, 1WEEK1secOnds").getYears(), 1.10136, 0.00001);
    }

    @Test
    public void testReparse() {
        TimeAPI timeAPI = new TimeAPI("1s");
        assertEquals(timeAPI.getSeconds(), 1, 0.1);
        timeAPI.reparse("2s");
        assertEquals(timeAPI.getSeconds(), 2, 0.1);
    }
}
