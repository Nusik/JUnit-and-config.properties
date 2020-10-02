package task1;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.Parameterized.Parameter;
import task1.Interfaces.RegressionTests;
import task1.Interfaces.SmokeTests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RetailTest {

    Retail retail = new Retail();

    @Before
    public void beforeTest() {
        System.out.println("Before each test");
    }

    @Parameter
    int actualMinOrder = 1000;

    @Test
    @Category(SmokeTests.class)
    public void testMinOrder() {
        assertThat(retail.minOrder, is(actualMinOrder));
    }

    @Test
    @Category(SmokeTests.class)
    public void testDiscountSize() {
        Assume.assumeTrue("Client doesn't have a discount! Skip the test", retail.haveDiscount);
        Assert.assertEquals("Wrong discount size!", 20, retail.discountSize());
    }

    @Test
    @Category(SmokeTests.class)
    public void testRegularType() {
        assertTrue("Client isn't regular", retail.isRegular);
    }

    @Test
    @Category(SmokeTests.class)
    public void testClientType() {
        String actualType = "RETAIL";
        assertSame(retail.clientType(), actualType);
    }

    @Test
    @Category(RegressionTests.class)
    public void testNewClientField() {
        assertNull("New Client field isn't null", retail.newClient);
    }

    @Test(timeout = 1000)
    @Category(RegressionTests.class)
    public void testTotalOrderSize() throws InterruptedException {
        try {
            Thread.sleep(100);
            System.out.println(retail.TotalOrderSize(1000, 5000));
        } catch (InterruptedException e) {
            System.out.println("Timeout more than 1000ms");
        }
    }

    @After
    public void afterTest() {
        System.out.println("After each test");
    }
}