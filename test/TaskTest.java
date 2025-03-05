package test;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Task;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private Task task;

    @BeforeEach
    void setUp() {
        // lets say Due in 2 days
        task = new Task("Complete Report", LocalDateTime.now().plusDays(2));
    }

    @Test
    void testAssignTo() {
        task.assignTo("Prosper Collins");
        Assert.assertEquals("Prosper Collins", task.getAssignedTo(), "Prosper Collins");
    }



    @Test
    void testUpdateStatusValid() {
        Task task = new Task("Test Task", LocalDateTime.now().plusDays(1));
        task.updateStatus("In Progress");
        assertEquals("In Progress", task.getStatus(), "In Progress");
    }

    @Test
    void testUpdateStatusInvalid() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            task.updateStatus("Unknown Status");
        });
        assertEquals("Invalid status", exception.getMessage());
    }

    @Test
    void testIsOverdueFalse() {
        Assertions.assertFalse(task.isOverdue(), "src.Task should not be overdue yet");
    }

    @Test
    void testIsOverdueTrue() {
        task = new Task("Old src.Task", LocalDateTime.now().minusDays(1)); // Due yesterday
        Assertions.assertTrue(task.isOverdue(), "src.Task should be overdue");
    }
}
