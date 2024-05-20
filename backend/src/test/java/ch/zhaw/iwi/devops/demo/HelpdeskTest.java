package ch.zhaw.iwi.devops.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class HelpdeskTest {

    private Helpdesk helpdesk;

    @BeforeEach
    void setUp() {
        helpdesk = new Helpdesk();
    }

    @Test
    void testDefaultConstructor() {
        Helpdesk helpdesk = new Helpdesk();
        assertEquals(0, helpdesk.getId());
        assertNull(helpdesk.getTitle());
        assertNull(helpdesk.getDescription());
    }

    @Test
    void testParameterizedConstructor() {
        Helpdesk helpdesk = new Helpdesk(1, "Issue Title", "Issue Description");
        assertEquals(1, helpdesk.getId());
        assertEquals("Issue Title", helpdesk.getTitle());
        assertEquals("Issue Description", helpdesk.getDescription());
    }

    @Test
    void testSetId() {
        helpdesk.setId(2);
        assertEquals(2, helpdesk.getId());
    }

    @Test
    void testGetTitle() {
        helpdesk = new Helpdesk(1, "Issue Title", "Issue Description");
        assertEquals("Issue Title", helpdesk.getTitle());
    }

    @Test
    void testGetDescription() {
        helpdesk = new Helpdesk(1, "Issue Title", "Issue Description");
        assertEquals("Issue Description", helpdesk.getDescription());
    }
}
