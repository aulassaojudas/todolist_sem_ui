/*
 * 
 * CLASSE ListaDeTarefas:
    CONSTANTE MAX_TAREFAS = 100
    PROPRIEDADES PRIVADAS:
        vetor de Tarefa tarefas com tamanho MAX_TAREFAS
        inteiro quantidade = 0  // número de tarefas atuais
        inteiro proximoId = 1   // id a ser usado na próxima tarefa

    MÉTODO CONSTRUTOR():
        inicializar o vetor tarefas com espaço para MAX_TAREFAS tarefas
        definir quantidade como 0
        definir proximoId como 1

    MÉTODO adicionarTarefa(descricao):
        SE quantidade >= MAX_TAREFAS:
            exibir "Limite de tarefas atingido!"
            retornar
        criar nova tarefa com id = proximoId e descricao fornecida
        adicionar essa tarefa no vetor na posição `quantidade`
        incrementar quantidade em 1
        incrementar proximoId em 1
        exibir "Tarefa adicionada: " seguido da representação da tarefa

    MÉTODO removerTarefa(id):
        definir encontrado como falso
        PARA i de 0 até (quantidade - 1):
            SE tarefa na posição i tem id igual ao fornecido:
                marcar encontrado como verdadeiro
                PARA j de i até (quantidade - 2):
                    mover tarefa da posição j+1 para a posição j
                definir a última posição do vetor como nula
                decrementar quantidade em 1
                exibir "Tarefa removida com id: " seguido do id
                sair do laço
        SE não encontrado:
            exibir "Tarefa não encontrada com id: " seguido do id

    MÉTODO marcarTarefaComoConcluida(id):
        PARA i de 0 até (quantidade - 1):
            SE tarefa na posição i tem id igual ao fornecido:
                marcar essa tarefa como concluída
                exibir "Tarefa concluída: " seguido da tarefa
                retornar
        exibir "Tarefa não encontrada com id: " seguido do id

    MÉTODO listarTarefas():
        exibir "Lista de Tarefas:"
        PARA i de 0 até (quantidade - 1):
            exibir a tarefa na posição i

 */

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