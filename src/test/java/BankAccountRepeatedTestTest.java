import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
// Repeating tests a number of times using annotations

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTestTest {
    @RepeatedTest(5) // we use the @RepeatedTest annotation to repeat tests based on the number specified
    @DisplayName("Deposited 500 successfully")
    public void testDeposit(BankAccount bankAccount) {
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }
}
