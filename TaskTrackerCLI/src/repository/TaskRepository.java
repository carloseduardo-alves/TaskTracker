package repository;

import entity.Task;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.*;

public class TaskRepository {
    private static final String FILE_NAME = "data/tasks.json";
    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    public TaskRepository() {
        createFileIfNotExists();
    }

    private void createFileIfNotExists() {
        try {
            Path path = Paths.get(FILE_NAME);
            if (!Files.exists(path)) {
                Files.write(path, "[]".getBytes());
            }
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }

    public List<Task> getAllTasks() {
        try (Reader reader = Files.newBufferedReader(Paths.get(FILE_NAME))) {
            Type taskListType = new TypeToken<List<Task>>() {}.getType();
            List<Task> tasks = gson.fromJson(reader, taskListType);
            return tasks != null ? tasks : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Erro ao ler tarefas: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void saveTasks(List<Task> tasks) {
        try (Writer writer = Files.newBufferedWriter(Paths.get(FILE_NAME))) {
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    public void addTask(String description) {
        List<Task> tasks = getAllTasks();
        int newId = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).getId() + 1;
        LocalDateTime now = LocalDateTime.now();
        Task newTask = new Task(newId, description, "todo", now, now);
        tasks.add(newTask);
        saveTasks(tasks);
        System.out.println("Tarefa adicionada com sucesso (ID: " + newId + ")");
    }
    
    public boolean updateTask(int id, String newDescription) {
        List<Task> tasks = getAllTasks();
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDescription(newDescription);
                task.setUpdatedAt(LocalDateTime.now());
                saveTasks(tasks);
                return true;
            }
        }
        return false;
    }

    public boolean updateTaskStatus(int id, String newStatus) {
        List<Task> tasks = getAllTasks();
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setStatus(newStatus);
                task.setUpdatedAt(LocalDateTime.now());
                saveTasks(tasks);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTask(int id) {
        List<Task> tasks = getAllTasks();
        boolean removed = tasks.removeIf(t -> t.getId() == id);
        if (removed) {
            saveTasks(tasks);
        }
        return removed;
    }
}
