/*
 * 
 INICIAR programa principal:

    criar nova ListaDeTarefas
    criar leitor de entrada (scanner)
    definir variável opcao como inteira

    REPETIR:
        exibir menu:
            1 - Adicionar Tarefa
            2 - Remover Tarefa
            3 - Marcar Tarefa como Concluída
            4 - Listar Tarefas
            0 - Sair

        solicitar ao usuário que escolha uma opção
        ler a opção escolhida

        ESCOLHA (opcao):
            CASO 1:
                solicitar ao usuário que digite a descrição da tarefa
                ler a descrição
                chamar o método para adicionar a tarefa na lista
                ENCERRAR CASO

            CASO 2:
                solicitar ao usuário o id da tarefa a ser removida
                ler o id
                chamar o método para remover a tarefa da lista
                ENCERRAR CASO

            CASO 3:
                solicitar ao usuário o id da tarefa a ser marcada como concluída
                ler o id
                chamar o método para marcar a tarefa como concluída
                ENCERRAR CASO

            CASO 4:
                chamar o método para listar todas as tarefas
                ENCERRAR CASO

            CASO 0:
                exibir mensagem "Saindo..."
                ENCERRAR CASO

            CASO PADRÃO:
                exibir "Opção inválida."

    ATÉ que a opção seja 0 (sair)

    fechar o leitor de entrada
FIM do programa

 */
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