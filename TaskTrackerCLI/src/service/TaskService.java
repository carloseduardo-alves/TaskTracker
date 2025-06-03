package service;

import java.util.List;
import entity.Task;
import repository.TaskRepository;

public class TaskService {
    private final TaskRepository repository;

    public TaskService() { this.repository = new TaskRepository(); }

    public void addTask(String description) {
        if (description == null || description.isBlank()) {
            System.out.println("Descrição da tarefa não pode estar vazia.");
            return;
        }
        repository.addTask(description.trim());
    }

    public void deleteTask(int id) {
        boolean success = repository.deleteTask(id);
        if (success) {
            System.out.println("Tarefa removida com sucesso.");
        } else {
            System.out.println("Tarefa com ID " + id + " não encontrada.");
        }
    }

    public void updateTask(int id, String newDescription) {
        boolean success = repository.updateTask(id, newDescription);
        if (success) {
            System.out.println("Tarefa atualizada com sucesso.");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private void updateStatus(int id, String newStatus) {
        boolean success = repository.updateTaskStatus(id, newStatus);
        if (success) {
            System.out.println("Status atualizado para: " + newStatus);
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    public void markInProgress(int id) {
        updateStatus(id, "in-progress");
    }

    public void markDone(int id) {
        updateStatus(id, "done");
    }

    public void listAll() {
        printTasks(repository.getAllTasks());
    }

    public void listByStatus(String status) {
        List<Task> filtered = repository.getAllTasks().stream()
                .filter(t -> t.getStatus().equalsIgnoreCase(status))
                .toList();

        printTasks(filtered);
    }

    private void printTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
            return;
        }

        for (Task t : tasks) {
            System.out.println("ID: " + t.getId());
            System.out.println("Descrição: " + t.getDescription());
            System.out.println("Status: " + t.getStatus());
            System.out.println("Criado em: " + t.getCreatedAt());
            System.out.println("Atualizado em: " + t.getUpdatedAt());
            System.out.println("-----");
        }
    }
}
