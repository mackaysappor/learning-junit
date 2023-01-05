import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {

    // Timeout tests using annotation
    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testDepositTimeoutAnnotation(BankAccount bankAccount) {
        try {
            Thread.sleep(100);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }

    // Timeout test using assertion
    @Test
    public void testDepositTimeoutAssertion(BankAccount bankAccount) {
        try {
            Thread.sleep(1000);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        bankAccount.deposit(300);
        assertTimeout(Duration.ofMillis(500), () ->{
            Thread.sleep(10);
        });
    }
}
