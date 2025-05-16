// Importa a classe ArrayList para armazenar listas dinâmicas de objetos
import java.util.ArrayList;

// Importa a classe Scanner para ler entradas do teclado
import java.util.Scanner;

// Classe que representa uma Pessoa
class Pessoa {
    // Atributos privados da pessoa: id, nome e idade
    private int id;
    private String nome;
    private int idade;

    // Construtor da classe Pessoa
    public Pessoa(int id, String nome, int idade) {
        this.id = id;           // Inicializa o id
        this.nome = nome;       // Inicializa o nome
        this.idade = idade;     // Inicializa a idade
    }

    // Método getter para retornar o id da pessoa
    public int getId() {
        return id;
    }

    // Método getter para retornar o nome
    public String getNome() {
        return nome;
    }

    // Método getter para retornar a idade
    public int getIdade() {
        return idade;
    }

    // Método setter para atualizar o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método setter para atualizar a idade
    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Método que exibe os dados da pessoa no console
    public void exibir() {
        System.out.println("ID: " + id + " | Nome: " + nome + " | Idade: " + idade);
    }
}

// Classe principal que simula o banco de dados
public class BancoSimulado {
    // Lista que funciona como um "banco de dados" em memória
    static ArrayList<Pessoa> banco = new ArrayList<>();

    // Scanner para ler dados do usuário via terminal
    static Scanner scanner = new Scanner(System.in);

    // Variável que representa o próximo ID disponível para cadastro
    static int proximoId = 1;

    // Método principal (ponto de entrada do programa)
    public static void main(String[] args) {
        int opcao; // variável para armazenar a opção escolhida pelo usuário

        // Estrutura de repetição para o menu
        do {
            // Exibe o menu no console
            System.out.println("\n=== Menu ===");
            System.out.println("1. Adicionar Pessoa");
            System.out.println("2. Listar Pessoas");
            System.out.println("3. Atualizar Pessoa");
            System.out.println("4. Remover Pessoa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); // Lê a opção
            scanner.nextLine(); // Consome a quebra de linha (enter)

            // Executa a ação conforme a opção escolhida
            switch (opcao) {
                case 1:
                    adicionarPessoa(); // Chama método para adicionar
                    break;
                case 2:
                    listarPessoas(); // Chama método para listar
                    break;
                case 3:
                    atualizarPessoa(); // Chama método para atualizar
                    break;
                case 4:
                    removerPessoa(); // Chama método para remover
                    break;
                case 0:
                    System.out.println("Encerrando..."); // Mensagem de saída
                    break;
                default:
                    System.out.println("Opção inválida."); // Caso o usuário digite algo inválido
            }

        } while (opcao != 0); // Repete até que a opção seja 0 (sair)
    }

    // Método que adiciona uma nova pessoa ao "banco"
    public static void adicionarPessoa() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine(); // Lê o nome
        System.out.print("Idade: ");
        int idade = scanner.nextInt(); // Lê a idade
        scanner.nextLine(); // Consome quebra de linha

        // Cria nova pessoa com o próximo ID disponível
        Pessoa nova = new Pessoa(proximoId++, nome, idade);
        banco.add(nova); // Adiciona à lista
        System.out.println("Pessoa adicionada com sucesso!");
    }

    // Método que lista todas as pessoas do "banco"
    public static void listarPessoas() {
        if (banco.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada."); // Mensagem se a lista estiver vazia
        } else {
            for (Pessoa p : banco) {
                p.exibir(); // Exibe os dados de cada pessoa
            }
        }
    }

    // Método que atualiza os dados de uma pessoa
    public static void atualizarPessoa() {
        System.out.print("Digite o ID da pessoa a ser atualizada: ");
        int id = scanner.nextInt(); // Lê o ID
        scanner.nextLine(); // Consome quebra de linha

        Pessoa pessoa = encontrarPorId(id); // Busca a pessoa pelo ID

        if (pessoa != null) {
            System.out.print("Novo nome: ");
            String nome = scanner.nextLine(); // Lê o novo nome
            System.out.print("Nova idade: ");
            int idade = scanner.nextInt(); // Lê a nova idade
            scanner.nextLine(); // Consome quebra de linha

            pessoa.setNome(nome); // Atualiza o nome
            pessoa.setIdade(idade); // Atualiza a idade
            System.out.println("Pessoa atualizada!");
        } else {
            System.out.println("Pessoa não encontrada."); // Se o ID não existir
        }
    }

    // Método que remove uma pessoa do "banco"
    public static void removerPessoa() {
        System.out.print("Digite o ID da pessoa a ser removida: ");
        int id = scanner.nextInt(); // Lê o ID
        scanner.nextLine(); // Consome quebra de linha

        Pessoa pessoa = encontrarPorId(id); // Busca a pessoa pelo ID

        if (pessoa != null) {
            banco.remove(pessoa); // Remove da lista
            System.out.println("Pessoa removida com sucesso.");
        } else {
            System.out.println("Pessoa não encontrada."); // Se o ID não existir
        }
    }

    // Método que busca uma pessoa pelo ID
    public static Pessoa encontrarPorId(int id) {
        for (Pessoa p : banco) {
            if (p.getId() == id) {
                return p; // Retorna a pessoa se encontrar o ID
            }
        }
        return null; // Retorna null se não encontrar
    }
}