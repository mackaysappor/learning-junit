import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {
    @Test
    @DisplayName("Deposited 500 successfully")
    public void testDeposit1(BankAccount bankAccount) {
        try {
            Thread.sleep(200);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposited 260 successfully")
    public void testDeposit2(BankAccount bankAccount) {
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        bankAccount.deposit(260);
        assertEquals(260, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposited 123 successfully")
    public void testDeposit3(BankAccount bankAccount) {
        try {
            Thread.sleep(1200);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        bankAccount.deposit(123);
        assertEquals(123, bankAccount.getBalance());
    }
}
