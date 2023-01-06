import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// @TestInstance(TestInstance.Lifecycle.PER_CLASS) //using this annotation we can remove the staic access modifier when using @BeforeAll
public class BankAccountBeforeAndAfterTest {
    static BankAccount bankAccount;

    @BeforeAll // executed before any tests are run. require methods to be static
    //@BeforeEach // executed each time a new test is to be run
    public static void prepTest(){
        bankAccount = new BankAccount(500, 0);
    }

    @Test
    public void withdraw(){
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    public void deposit(){
        bankAccount.deposit(200);
        assertEquals(400, bankAccount.getBalance());
    }

    @AfterAll // executed after all tests are ran. require methods to be static
    //@AfterEach // executed each time a new test has been executed
    public static void endTest(){
        System.out.println("Bye!!");
    }
}
