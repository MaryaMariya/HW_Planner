import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testSimpleTaskMatches() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }
    @Test

    public void testSimpleTaskNotMatches(){
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean expected = false;
        boolean actual= simpleTask.matches("Написать");

        Assertions.assertEquals(expected, actual);
    }

}
