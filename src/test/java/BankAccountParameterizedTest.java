import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Running tests with multiple values
// We use the @ParameterizedTest annotation to add multiple parameters to our tests
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTest {
    // Parameterized Tests using values from value source
    @ParameterizedTest
    @ValueSource(ints = {100, 400, 800, 200})
    @DisplayName("Depositing successfully")
    public void testDepositValueSource(int amount, BankAccount bankAccount) {
        bankAccount.deposit(amount);
        assertEquals(amount, bankAccount.getBalance());
    }

    // Parameterized Tests using values from a Csv source
    @ParameterizedTest
    //@CsvSource({"100, Mark", "300, Ted", "250, Jeff"}) //using this annotation we have to manually type the values
    @CsvFileSource(resources = "details.csv") // using this annotation we can specify a csv file. you can also specify the delimter used
    public void depositAndNameTest(int amount, String name, BankAccount bankAccount)
    {
        bankAccount.deposit(amount);
        bankAccount.setHolderName(name);
        assertEquals(amount, bankAccount.getBalance());
        assertEquals(name, bankAccount.getHolderName());
    }
}
