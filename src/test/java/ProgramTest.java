import com.it_academy.practice.junit_basics.Main;

import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramTest {
    @Test
    public void testInput() throws FileNotFoundException {
        Main program = new Main();
        FileInputStream steam = new FileInputStream("src/test/resources/Input");
        assertDoesNotThrow(()->program.run(steam));
    }
    @Test
    public void testWrongInput() throws FileNotFoundException {
        Main program = new Main();
        FileInputStream steam = new FileInputStream("src/test/resources/WrongInput");
        assertThrows(NumberFormatException.class, ()->program.run(steam));
    }
}
