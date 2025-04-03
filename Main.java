
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);
        
        int option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar Tarefa");
            System.out.println("2 - Remover Tarefa");
            System.out.println("3 - Marcar Tarefa como Concluída");
            System.out.println("4 - Listar Tarefas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String description = scanner.nextLine();
                    todoList.addTask(description);
                    break;
                case 2:
                    System.out.print("Digite o id da tarefa a remover: ");
                    int removeId = scanner.nextInt();
                    todoList.removeTask(removeId);
                    break;
                case 3:
                    System.out.print("Digite o id da tarefa a marcar como concluída: ");
                    int completeId = scanner.nextInt();
                    todoList.markTaskCompleted(completeId);
                    break;
                case 4:
                    todoList.listTasks();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);

        scanner.close();
    }
}