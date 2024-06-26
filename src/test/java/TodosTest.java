import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenFewFound(){
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[]expected = {simpleTask,epic};
        Task[]actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenOneFound(){
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[]expected = {meeting};
        Task[]actual = todos.search("Приложение");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearchWhenZeroFound(){
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[]expected = {};
        Task[]actual = todos.search("Позвонить");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchMeetings() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(meeting);
        String query = "Выкатка 3й версии приложения";

        Task[] expected = {meeting};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSearchIfSeveralSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(2, "Позвонить сестре");
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(simpleTask2);
        String query = "Позвонить сестре";

        Task[] expected = {simpleTask2};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchIfNoEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};

        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);
        todos.add(epic);
        String query = "Сыр";

        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }
    public void shouldSearchIfSeveralMeetings() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Meeting meeting2 = new Meeting(
                123,
                "Выкатка 4й версии приложения",
                "Приложение ПростоБанка",
                "В понедельник вечером"
        );
        Todos todos = new Todos();

        todos.add(meeting);
        todos.add(meeting2);
        String query = "Выкатка 4й версии приложения";

        Task[] expected = {meeting2};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfSeveralEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        String[] subtasks2 = {"Масло", "Булка", "Макароны"};
        Epic epic = new Epic(55, subtasks);
        Epic epic2 = new Epic(11, subtasks2);
        Todos todos = new Todos();

        todos.add(epic);
        todos.add(epic2);
        String query = "Масло";

        Task[] expected = {epic2};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfNoSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();

        todos.add(simpleTask);
        String query = "Погладить кошку";

        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfNoMeetings() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);
        String query = "Выкатка 4й версии приложения";

        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchSeveralSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(2, "Позвонить подруге");
        SimpleTask simpleTask3 = new SimpleTask(7, "Позвонить мужу");
        SimpleTask simpleTask4 = new SimpleTask(12, "Погладить кошку");
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(simpleTask4);
        String query = "Позвонить";

        Task[] expected = {simpleTask, simpleTask2, simpleTask3};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void test_1(){
        Task task = new Task(1);
        SimpleTask simpleTask = new SimpleTask(10, "Энциклопедия для чайников");

        String[] subtasks = {"Энциклопедия для мальчиков", "Словарь", "Выучить язык"};
        Epic epic = new Epic(60, subtasks);

        Meeting meeting = new Meeting(
                57,
                "Энциклопедия спорта",
                "Архаизм",
                "08.09.2023"
        );
        Todos todos = new Todos();

        todos.add(task);
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean[] expected = {false, true, true, true};
        boolean[] actual = new boolean[4];

        Task[] arrayTask = todos.findAll();

        for (int i = 0; i < arrayTask.length; i++) {
            actual[i] = arrayTask[i].matches("Энциклопедия");
        }

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void test_2(){
        Task task = new Task(1);
        SimpleTask simpleTask = new SimpleTask(10, "Энциклопедия для чайников");

        String[] subtasks = {"Энциклопедия для мальчиков", "Словарь", "Выучить язык"};
        Epic epic = new Epic(60, subtasks);

        Meeting meeting = new Meeting(
                57,
                "Энциклопедия спорта",
                "Архаизм",
                "08.09.2023"
        );
        Todos todos = new Todos();

        todos.add(task);
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean[] expected = {false, true, true, true};
        boolean[] actual = new boolean[4];

        Task[] arrayTask = todos.findAll();

        for (int i = 0; i < arrayTask.length; i++) {
            actual[i] = arrayTask[i].matches("Энциклопедия");
        }

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void test_3() {
        SimpleTask simpleTask = new SimpleTask(10, "Пособие для чайников");

        String[] subtasks = {"Бизнес с нуля", "Отправить письмо", "Позвонить коллеге"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                100,
                "Английская схема",
                "Обновление ПО",
                "08.09.2023"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean[] expected = {false, false, false};
        boolean[] actual = new boolean[3];

        Task[] arrayTask = todos.findAll();

        for (int i = 0; i < arrayTask.length; i++) {
            actual[i] = arrayTask[i].matches("Верификация");
        }

        Assertions.assertArrayEquals(expected, actual);
    }

}
