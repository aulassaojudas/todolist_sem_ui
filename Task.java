/*
 * 
 * CLASSE Tarefa:
    PROPRIEDADES PRIVADAS:
        inteiro id
        texto descricao
        booleano concluida

    MÉTODO CONSTRUTOR(id, descricao):
        definir o id da tarefa
        definir a descricao da tarefa
        marcar a tarefa como não concluída (concluida = falso)

    MÉTODO obterId():
        retornar o id da tarefa

    MÉTODO obterDescricao():
        retornar a descricao da tarefa

    MÉTODO estaConcluida():
        retornar se a tarefa está concluída (true ou false)

    MÉTODO marcarComoConcluida():
        definir concluida como verdadeiro

    MÉTODO toString():
        retornar uma string formatada com:
            - o id da tarefa
            - a descrição
            - o estado (concluída ou não)
 */

public class Task {
    private int id;
    private String description;
    private boolean completed;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "Tarefa   : " + "id=" + id + "\n" +
               "Descrição: " + description + "\n" +
               "Completa : " + completed ;
    }
}
