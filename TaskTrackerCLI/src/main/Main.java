package main;

import service.TaskService;

import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        TaskService service = new TaskService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Bem-vindo ao Task Tracker!");

        try {
            while (running) {
                exibirMenu();

                String input = scanner.nextLine();

                try {
                    switch (input) {
                        case "1": // add
                            System.out.print("Digite a descrição da tarefa: ");
                            String desc = scanner.nextLine();
                            service.addTask(desc);
                            break;

                        case "2": // update
                            int idUpdate = lerId(scanner);
                            System.out.print("Nova descrição: ");
                            String newDesc = scanner.nextLine();
                            service.updateTask(idUpdate, newDesc);
                            break;

                        case "3": // delete
                            int idDelete = lerId(scanner);
                            service.deleteTask(idDelete);
                            break;

                        case "4": // mark-in-progress
                            int idProgress = lerId(scanner);
                            service.markInProgress(idProgress);
                            break;

                        case "5": // mark-done
                            int idDone = lerId(scanner);
                            service.markDone(idDone);
                            break;

                        case "6": // list all
                            service.listAll();
                            break;

                        case "7": // list by status
                            System.out.println("Status disponíveis: todo, in-progress, done");
                            System.out.print("Digite o status desejado: ");
                            String status = scanner.nextLine().toLowerCase();
                            Set<String> validStatuses = Set.of("todo", "in-progress", "done");

                            if (!validStatuses.contains(status)) {
                                System.out.println("Status inválido. Use: todo, in-progress ou done.");
                            } else {
                                service.listByStatus(status);
                            }
                            break;

                        case "0": // sair
                            running = false;
                            System.out.println("Encerrando...");
                            break;

                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }

                System.out.println("\n-----------------------------");
            }

        } finally {
            scanner.close();
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== Task Tracker ===");
        System.out.println("1. Adicionar tarefa");
        System.out.println("2. Atualizar tarefa");
        System.out.println("3. Excluir tarefa");
        System.out.println("4. Marcar como 'em andamento'");
        System.out.println("5. Marcar como 'concluída'");
        System.out.println("6. Listar todas as tarefas");
        System.out.println("7. Listar tarefas por status");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerId(Scanner scanner) {
        System.out.print("ID da tarefa: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID inválido. Deve ser um número inteiro.");
        }
    }
}