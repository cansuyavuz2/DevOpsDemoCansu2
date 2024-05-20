package ch.zhaw.iwi.devops.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelpdeskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() throws Exception {
        // Ensure the data is initialized
        mockMvc.perform(get("/services/helpdesk"))
                .andExpect(status().isOk());
    }

    @Test
    public void testPing() throws Exception {
        mockMvc.perform(get("/services/ping"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("ok")))
                .andExpect(jsonPath("$.userId", is("admin")))
                .andExpect(jsonPath("$.languageCode", is("de")))
                .andExpect(jsonPath("$.version", is("0.0.1")));
    }

    @Test
    public void testCount() throws Exception {
        mockMvc.perform(get("/count"))
                .andExpect(status().isOk())
                .andExpect(content().string("3"));
    }

    @Test
    public void testGetHelpdesks() throws Exception {
        mockMvc.perform(get("/services/helpdesk"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }
    
    @Test
    public void testCreateHelpdesk() throws Exception {
        Helpdesk newHelpdesk = new Helpdesk(0, "New Issue", "New Description");
        mockMvc.perform(post("/services/helpdesk")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newHelpdesk)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/count"))
                .andExpect(status().isOk())
                .andExpect(content().string("4"));
    }

    @Test
    public void testUpdateHelpdesk() throws Exception {
        Helpdesk updatedHelpdesk = new Helpdesk(1, "Updated Issue", "Updated Description");
        mockMvc.perform(put("/services/helpdesk/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedHelpdesk)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/services/helpdesk/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Updated Issue")))
                .andExpect(jsonPath("$.description", is("Updated Description")));
    }

    @Test
    public void testDeleteHelpdesk() throws Exception {
        mockMvc.perform(delete("/services/helpdesk/1"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/services/helpdesk/1"))
                .andExpect(status().isNotFound());
    }
}