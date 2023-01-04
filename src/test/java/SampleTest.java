import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SampleTest {

    @Test
    public void testSayHello()
    {
        Sample sample = new Sample();
        assertEquals("Hello World", sample.sayHello());
    }
}
