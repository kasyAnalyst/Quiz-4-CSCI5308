package src;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Task {
    private String title;
    private String assignedTo;
    private String status;
    private LocalDateTime dueDate;

    private static final List<String> VALID_STATUSES = Arrays.asList("Pending", "In Progress", "Completed");

    public Task(String title, LocalDateTime dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        this.status = "Pending"; // Okay here I put as the default status just in case
    }

    public void assignTo(String teamMember) {
        this.assignedTo = teamMember;
    }

    public void updateStatus(String newStatus) {
        if (!VALID_STATUSES.contains(newStatus)) {
            throw new IllegalArgumentException("Invalid status");
        }
        this.status = newStatus;
    }



    public boolean isOverdue() {
        return LocalDateTime.now().isAfter(dueDate);
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public String getStatus() {
        return status; // ✅ This should return only the status, nothing else
    }


    public String getTitle() {
        return title;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }
}
