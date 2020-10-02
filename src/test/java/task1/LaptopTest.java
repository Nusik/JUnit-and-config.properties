package task1;

import task1.Interfaces.RegressionTests;
import task1.Interfaces.SmokeTests;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.Parameterized.Parameter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class LaptopTest {

    Laptop laptop = new Laptop();

    @Before
    public void beforeTest() {
        System.out.println("Before each test");
    }

    @Parameter
    int actualTotalNumberOfLaptop = 2000;

    @Test
    @Category(SmokeTests.class)
    public void testNumberOfLaptop() {
        assertThat(laptop.totalNumber(), is(actualTotalNumberOfLaptop));
    }

    @Test(timeout = 1000)
    @Category(RegressionTests.class)
    public void testLaptopProducer() {
        Assume.assumeFalse("Laptop has SSD! Skip the test", laptop.ssd);
        Assert.assertEquals("Wrong producer of laptop!", "Dell", laptop.producer);
    }

    @Test
    @Category(SmokeTests.class)
    public void testSSD() {
        assertTrue("Laptop hasn't SSD", laptop.ssd);
    }

    @Test
    @Category(SmokeTests.class)
    public void testSystem() {
        assertSame(laptop.osLinux(), "Linux");
    }

    @Test
    @Category(RegressionTests.class)
    public void testKeyboard() {
        assertNull("The keyboard field isn't null", laptop.keyboard);
    }

    @Test(timeout = 150)
    @Category(RegressionTests.class)
    public void testCountLaptops() throws InterruptedException {
        try {
            Thread.sleep(140);
            laptop.countLaptops(10, 10);
        } catch (InterruptedException e) {
            System.out.println("Timeout more than 150ms");
        }
    }

    @After
    public void afterTest() {
        System.out.println("After each test");
    }
}