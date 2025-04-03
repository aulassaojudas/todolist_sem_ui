

public class TodoList {
    private final int MAX_TASKS = 100; // Tamanho máximo do array
    private Task[] tasks;
    private int count; // Número atual de tarefas
    private int nextId;

    public TodoList() {
        tasks = new Task[MAX_TASKS];
        count = 0;
        nextId = 1;
    }

    // Adiciona uma tarefa ao array
    public void addTask(String description) {
        if (count >= MAX_TASKS) {
            System.out.println("Limite de tarefas atingido!");
            return;
        }
        Task newTask = new Task(nextId, description);
        tasks[count] = newTask;
        count++;
        nextId++;
        System.out.println("Tarefa adicionada: " + newTask);
    }

    // Remove a tarefa com o ID especificado (realocando os elementos do array)
    public void removeTask(int id) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (tasks[i].getId() == id) {
                found = true;
                // Desloca os elementos para a esquerda
                for (int j = i; j < count - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
                tasks[count - 1] = null;
                count--;
                System.out.println("Tarefa removida com id: " + id);
                break;
            }
        }
        if (!found) {
            System.out.println("Tarefa não encontrada com id: " + id);
        }
    }

    // Marca uma tarefa como concluída
    public void markTaskCompleted(int id) {
        for (int i = 0; i < count; i++) {
            if (tasks[i].getId() == id) {
                tasks[i].markCompleted();
                System.out.println("Tarefa concluída: " + tasks[i]);
                return;
            }
        }
        System.out.println("Tarefa não encontrada com id: " + id);
    }

    // Lista todas as tarefas
    public void listTasks() {
        System.out.println("Lista de Tarefas:");
        for (int i = 0; i < count; i++) {
            System.out.println(tasks[i]);
        }
    }
}