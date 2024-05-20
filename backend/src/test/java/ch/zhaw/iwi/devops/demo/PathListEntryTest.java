package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PathListEntryTest {

    private PathListEntry<String> entry;

    @BeforeEach
    void setUp() {
        entry = new PathListEntry<>();
    }

    @Test
    void testPathListEntryEqualsAndHashCode() {
        // Test equality and hash code when key is not null
        PathListEntry<String> entry1 = new PathListEntry<>();
        entry1.setKey("key1", "name1");

        PathListEntry<String> entry2 = new PathListEntry<>();
        entry2.setKey("key1", "name1");

        assertEquals(entry1, entry2);
        assertEquals(entry1.hashCode(), entry2.hashCode());

        // Test equality and hash code when key is null
        PathListEntry<String> entry3 = new PathListEntry<>();
        entry3.setKey(null, null);

        PathListEntry<String> entry4 = new PathListEntry<>();
        entry4.setKey(null, null);

        assertEquals(entry3, entry4);
        assertEquals(entry3.hashCode(), entry4.hashCode());

        // Test inequality when key values are different
        entry2.setKey("key2", "name1");
        assertNotEquals(entry1, entry2);
        assertNotEquals(entry1.hashCode(), entry2.hashCode());

        // Test inequality when key names are different
        entry2.setKey("key1", "name2");
        assertNotEquals(entry1, entry2);
        assertNotEquals(entry1.hashCode(), entry2.hashCode());

        // Test inequality when one entry has null key
        entry4.setKey("key1", "name1");
        assertNotEquals(entry3, entry4);
        assertNotEquals(entry3.hashCode(), entry4.hashCode());

        // Test inequality when one entry has null key and the other doesn't
        entry4.setKey(null, "name1");
        assertNotEquals(entry3, entry4);
        assertNotEquals(entry3.hashCode(), entry4.hashCode());

        // Test equality and hash code when key is not null but name is null
        PathListEntry<String> entry5 = new PathListEntry<>();
        entry5.setKey("key1", null);

        PathListEntry<String> entry6 = new PathListEntry<>();
        entry6.setKey("key1", null);

        assertEquals(entry5, entry6);
        assertEquals(entry5.hashCode(), entry6.hashCode());
    }
}
