package task1;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.Parameterized.Parameter;
import task1.Interfaces.RegressionTests;
import task1.Interfaces.SmokeTests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RadioTest {

    Radio radio = new Radio();

    @Before
    public void beforeTest() {
        System.out.println("Before each test");
    }

    @Parameter
    String actualAlert = "Tornado!";

    @Test
    @Category(SmokeTests.class)
    public void testWarningAlarm() {
        assertThat(radio.warningAlarm(), is(actualAlert));
    }

    @Test
    @Category(RegressionTests.class)
    public void testWeatherRadio() {
        Assume.assumeTrue("Radio doesn't have a weather scan! Skip the test", radio.weatherScan);
        Assert.assertEquals("Wrong radio type!", "weather radio", radio.radioType);
    }

    @Test
    @Category(SmokeTests.class)
    public void testAlarmClock() {
        assertTrue("Radio doesn't have an alarm clock", radio.alarmClockPresent);
    }

    @Test
    @Category(SmokeTests.class)
    public void testCategory() {
        assertSame(radio.category(), "prime");
    }

    @Test
    @Category(RegressionTests.class)
    public void testFm() {
        assertNull("The FM field isn't null", radio.fm);
    }

    @Test(timeout = 200)
    @Category(RegressionTests.class)
    public void testNumberOfChannels() throws InterruptedException {
        try {
            Thread.sleep(100);
            System.out.println(radio.NumberOfChannels);
        } catch (InterruptedException e) {
            System.out.println("Timeout more than 200ms");
        }
    }

    @After
    public void afterTest() {
        System.out.println("After each test");
    }
}