package task1;

import task1.Interfaces.IntegrationTests;
import task1.Interfaces.RegressionTests;
import task1.Interfaces.SmokeTests;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.concurrent.TimeoutException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class EmployeeTest {

    Employee employee = new Employee();

    @Before
    public void beforeTest() {
        System.out.println("Before each test");
    }

    @Test(timeout = 300)
    @Category(RegressionTests.class)
    public void testPosition() {
        Assume.assumeFalse("Employee is a newcomer! Skip the test", employee.isNewcomer);
        Assert.assertEquals("Wrong position!", "ADMIN", employee.positionUppercase("admin"));
    }

    @Test
    @Category(SmokeTests.class)
    public void testNewComer() {
        assertTrue("Employee isn't a newcomer", employee.isNewcomer);
    }

    @Parameter
    public int actualDaysOfVacationLeft = 5;

    @Test
    @Category(IntegrationTests.class)
    public void testDaysOfVacationLeft() {
        assertSame(employee.DaysOfVacationLeft(), actualDaysOfVacationLeft);
    }

    @Test
    @Category(SmokeTests.class)
    public void testAddress() {
        assertNull("The address field isn't null", employee.address);
    }

    @Parameters(name = "Cashier")
    @Test
    @Category(SmokeTests.class)
    public void testEmployeeGroup() {
        assertThat(employee.group, is("Cashier"));
    }

    @Test(timeout = 200)
    @Category(RegressionTests.class)
    public void testCountEmployeeInGroup() throws TimeoutException {
        try {
            Thread.sleep(100);
            employee.DaysOfVacationLeft();
        } catch (InterruptedException e) {
            System.out.println("Timeout more than 200ms");
        }
    }

    @After
    public void afterTest() {
        System.out.println("After each test");
    }
}