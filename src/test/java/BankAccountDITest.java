import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 Implementing dependency injection on the field and constructor level using a parameter resolver
 */
@ExtendWith(BankAccountParameterResolver.class) // the ExtendWith annotation allows us to call the Parameter Resolver class
public class BankAccountDITest {
    @Test
    @DisplayName("Deposited 500 successfully")
    public void testDeposit(BankAccount bankAccount) {
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }
}
