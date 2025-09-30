import java.util.Scanner;

public class aplicação {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fila fila = new Fila();

        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. enfileirar");
            System.out.println("2. desenfileirar");
            System.out.println("3. exibir primeiro");
            System.out.println("4. exibir fila");
            System.out.println("5. sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {
                System.out.print("Digite um valor para enfileirar: ");
                String nome = scanner.nextLine();
                fila.enfileirar(nome);
            } else if (opcao == 2) {
                fila.desenfileirar();
            } else if (opcao == 3) {
                fila.exibirPrimeiro();
            } else if (opcao == 4) {
                fila.exibirFila();
            } else if (opcao == 5) {
                System.out.println("Encerrando o programa...");
            } else {
                System.out.println("Opção inválida");
            }
        }
        scanner.close();
    }
}

class No {
    String nome;
    No proximo;

    public No(String nome) {
        this.nome = nome;
        this.proximo = null;
    }
}

class Fila {
    private No inicio;
    private No fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }

    public void enfileirar(String nome) {
        No novoNo = new No(nome);

        if (fim == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
        }
        System.out.println(nome + " enfileirado");
    }

    public void desenfileirar() {
        if (inicio == null) {
            System.out.println("não tem nada para desenfileirar");
        } else {
            System.out.println(inicio.nome + " desenfileirado");
            inicio = inicio.proximo;
            if (inicio == null) {
                fim = null;
            }
        }
    }

    public void exibirPrimeiro() {
        if (inicio == null) {
            System.out.println("não tem nada aqui");
        } else {
            System.out.println("elemento 1: " + inicio.nome);
        }
    }

    public void exibirFila() {
        if (inicio == null) {
            System.out.println("fila vazia");
            return;
        }
        System.out.print("fila: ");
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.nome + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}

