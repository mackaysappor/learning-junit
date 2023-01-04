import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing bank account class")
public class BankAccountTest {
    BankAccount bankAccount = new BankAccount(500, -1000);
    @Test
    @DisplayName("Withdrawn 500 successfully")
    public void testWithdrawal()
    {
        bankAccount.withdraw(500);
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposited 500 successfully")
    public void testDeposit() {
        bankAccount.deposit(500);
        assertEquals(1000, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Testing Negatives")
    public void testWithdrawalforNeg(){
        bankAccount.withdraw(800);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test if account is active")
    public void testActive(){
        BankAccount bankAcct = new BankAccount(600, -1000);
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test withdrawal below minimum")
    public void testBelowMinimumBalance(){
        BankAccount bankAcct = new BankAccount(600, -1);
        assertThrows(RuntimeException.class, () -> bankAcct.withdraw(1000));
    }

    @Test
    @DisplayName("Test deposit speed")
    public void testDepositSpeed(){
        BankAccount bankAcct = new BankAccount(600, -1);
        assertTimeout(Duration.ofNanos(1), () ->bankAcct.deposit(200));
    }
}
