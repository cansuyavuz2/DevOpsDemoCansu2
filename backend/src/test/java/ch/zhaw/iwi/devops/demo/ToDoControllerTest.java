package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToDoControllerTest {

    private ToDoController controller;

    @BeforeEach
    void setUp() {
        controller = new ToDoController();
        controller.init();
    }

    @Test
    void testCount() {
        assertEquals(5, controller.count());
    }

    @Test
    void testGetTodo() {
        ToDo todo = controller.getTodo(1);
        assertNotNull(todo);
        assertEquals("Neuer Job", todo.getTitle());
    }

    @Test
    void testDeleteTodo() {
        controller.deleteTodo(1);
        assertEquals(4, controller.count());
        assertNull(controller.getTodo(1));
    }

    @Test
    void testUpdateTodo() {
        var todo = new ToDo(2, "Updated Title", "Updated Description");
        controller.createTodo(2, todo);
        ToDo updatedTodo = controller.getTodo(2);
        assertEquals("Updated Title", updatedTodo.getTitle());
        assertEquals("Updated Description", updatedTodo.getDescription());
    }

    @Test
    void testTodoEndpoint() {
        List<PathListEntry<Integer>> todos = controller.todo();
        assertEquals(5, todos.size());

        PathListEntry<Integer> entry = todos.get(0);
        assertEquals("Neuer Job", entry.getName());
        assertEquals(1, entry.getDetails().size());
        assertEquals("5 DevOps Engineers einstellen", entry.getDetails().get(0));
        assertEquals("5 DevOps Engineers einstellen", entry.getTooltip());
    }

    @Test
    void testPing() {
        String expectedResponse = "{ \"status\": \"ok\", \"userId\": \"admin\", \"languageCode\": \"de\",\"version\": \"0.0.1\"}";
        assertEquals(expectedResponse, controller.ping());
    }

    @Test
    void testCreateTodo() {
        ToDo newTodo = new ToDo(0, "New Task", "New Task Description");
        controller.createTodo(newTodo);
        assertEquals(6, controller.count());
        ToDo retrievedTodo = controller.getTodo(6);
        assertNotNull(retrievedTodo);
        assertEquals("New Task", retrievedTodo.getTitle());
        assertEquals("New Task Description", retrievedTodo.getDescription());
    }

    @Test
    void testTestEndpoint() {
        assertEquals("ToDo app is up and running!", controller.test());
    }

    @Test
    void testPathListEntryDefaultConstructor() {
        PathListEntry<String> pathListEntry = new PathListEntry<>();
        assertTrue(pathListEntry.isActive());
        assertNull(pathListEntry.getKey());
        assertNull(pathListEntry.getName());
        assertNull(pathListEntry.getColor());
        assertNull(pathListEntry.getIcon());
        assertNull(pathListEntry.getUrl());
        assertNull(pathListEntry.getPage());
        assertNull(pathListEntry.getType());
        assertNull(pathListEntry.getTooltip());
        assertEquals(0.0, pathListEntry.getOrder());
        assertTrue(pathListEntry.getDetails().isEmpty());
        assertNull(pathListEntry.getForm());
    }

    @Test
    void testPathListEntrySetAndGetKey() {
        PathListEntry<String> pathListEntry = new PathListEntry<>();
        pathListEntry.setKey("key1", "name1");
        PathListEntry<String>.Key key = pathListEntry.getKey();
        assertNotNull(key);
        assertEquals("key1", key.getKey());
        assertEquals("name1", key.getName());
    }

    @Test
    void testPathListEntrySetAndGetName() {
        PathListEntry<String> pathListEntry = new PathListEntry<>();
        pathListEntry.setName("Test Name");
        assertEquals("Test Name", pathListEntry.getName());
    }

    @Test
    void testPathListEntrySetAndGetColor() {
        PathListEntry<String> pathListEntry = new PathListEntry<>();
        pathListEntry.setColor("Red");
        assertEquals("Red", pathListEntry.getColor());
    }

    @Test
    void testPathListEntrySetAndGetIcon() {
        PathListEntry<String> pathListEntry = new PathListEntry<>();
        pathListEntry.setIcon("icon.png");
        assertEquals("icon.png", pathListEntry.getIcon());
    }

    @Test
    void testPathListEntrySetAndGetUrl() {
        PathListEntry<String> pathListEntry = new PathListEntry<>();
        pathListEntry.setUrl("http://example.com");
        assertEquals("http://example.com", pathListEntry.getUrl());
    }

    @Test
    void testPathListEntrySetAndGetPage() {
        PathListEntry<String> pathListEntry = new PathListEntry<>();
        pathListEntry.setPage("home");
        assertEquals("home", pathListEntry.getPage());
    }

    @Test
    void testPathListEntrySetAndGetType() {
        PathListEntry<String> pathListEntry = new PathListEntry<>();
        pathListEntry.setType("type1");
        assertEquals("type1", pathListEntry.getType());
    }

    @Test
    void testPathListEntrySetAndGetTooltip() {
        PathListEntry<String> pathListEntry = new PathListEntry<>();
        pathListEntry.setTooltip("This is a tooltip");
        assertEquals("This is a tooltip", pathListEntry.getTooltip());
    }

    @Test
    void testPathListEntrySetAndGetOrder() {
        PathListEntry<String> pathListEntry = new PathListEntry<>();
        pathListEntry.setOrder(5.5f);
        assertEquals(5.5f, pathListEntry.getOrder());
    }

    @Test
    void testPathListEntrySetAndGetDetails() {
        PathListEntry<String> pathListEntry = new PathListEntry<>();
        List<String> details = new ArrayList<>();
        details.add("Detail 1");
        details.add("Detail 2");
        pathListEntry.setDetails(details);
        assertEquals(details, pathListEntry.getDetails());
    }

    @Test
    void testPathListEntrySetAndGetForm() {
        PathListEntry<String> pathListEntry = new PathListEntry<>();
        pathListEntry.setForm("form1");
        assertEquals("form1", pathListEntry.getForm());
        pathListEntry.setForm(null);
        assertNull(pathListEntry.getForm());
    }

    @Test
    void testPathListEntrySetAndGetActive() {
        PathListEntry<String> pathListEntry = new PathListEntry<>();
        pathListEntry.setActive(false);
        assertFalse(pathListEntry.isActive());
    }

    @Test
    void testPathListEntryEqualsAndHashCode() {
        PathListEntry<String> entry1 = new PathListEntry<>();
        entry1.setKey("key1", "name1");

        PathListEntry<String> entry2 = new PathListEntry<>();
        entry2.setKey("key1", "name1");

        assertEquals(entry1, entry2);
        assertEquals(entry1.hashCode(), entry2.hashCode());

        entry2.setKey("key2", "name2");
        assertNotEquals(entry1, entry2);
        assertNotEquals(entry1.hashCode(), entry2.hashCode());
    }
}
