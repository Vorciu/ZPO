
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Lab1Test {

    @Test
    public void testLevQWERTY() {
        assertEquals(1.5, Lab1.LevQWERTY("kot", "kita"));
        assertEquals(0.0, Lab1.LevQWERTY("", ""));
        assertEquals(2.0, Lab1.LevQWERTY("domek", "dom"));
    }

}
