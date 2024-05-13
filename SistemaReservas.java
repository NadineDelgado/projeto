import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class Utilizador {
    private String nome;
    private String email;
    private int telefone;

    public Utilizador(String nome, String email, int telefone){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public int getTelefone(){
        return telefone;
    }
}

class Cliente extends Utilizador{
    public Cliente(String nome, String email, int telefone){
        super(nome, email, telefone);
    }
}

class Funcionario extends Utilizador{
    public Funcionario(String nome, String email, int telefone){
        super(nome, email, telefone);
    }
}

class Autenticacao{
    private Map<String, String> credenciais;

    public Autenticacao(){
        this.credenciais = new HashMap<>();
    }

    public void registrarUtilizador(String email, String senha){
        credenciais.put(email, senha);
    }

    public boolean autenticarUtilizador(String email, String senha){
        String senhaSalva = credenciais.get(email);
        return senhaSalva != null && senhaSalva.equals(senha);
    }
}

public class SistemaReservas {

    private static Autenticacao autenticacao = new Autenticacao();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        mostrarMenuInicial();
    }

    private static void mostrarMenuInicial() {
        int opcao;
        do {
            System.out.println("Bem-vindo ao Sistema de Reservas!");
            System.out.println("Escolha o tipo de usuário:");
            System.out.println("1. Cliente");
            System.out.println("2. Funcionário");
            System.out.println("3. Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuCliente();
                    break;
                case 2:
                    menuFuncionario();
                    break;
                case 3:
                    System.out.println("Saindo do programa.");
                    return; 
                default:
                    System.out.println("Opção inválida.");
            }
        } while (true); 
    }

    private static void menuCliente() {
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.println("Digite seu telefone: ");
        int telefone = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Cadastro concluído com sucesso!");

        boolean autenticado = fazerLogin();
       
        if (autenticado) {
            exibirMenuCliente();
        } else {
            System.out.println("Credenciais inválidas. Encerrando o programa.");
        }
    }

    private static void menuFuncionario() {
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.println("Digite seu telefone: ");
        int telefone = scanner.nextInt();
        scanner.nextLine();

        autenticacao.registrarUtilizador(email, senha); 

        System.out.println("Cadastro concluído com sucesso!");

        boolean autenticado = fazerLogin();
        
        if (autenticado) {
            exibirMenuFuncionario();
        } else {
            System.out.println("Credenciais inválidas. Encerrando o programa.");
        }
    }

    private static boolean fazerLogin(){
        System.out.println("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();
        return autenticacao.autenticarUtilizador(email, senha);
    }

    private static void exibirMenuCliente(){
        int opcao;
        do {
            System.out.println("Bem Vindo ao Sistema de Reservas!");
            System.out.println("1. Pesquisar hotéis");
            System.out.println("2. Fazer reserva");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    pesquisarHoteis();
                    break;
                case 2:
                    fazerReserva();
                    break;
                case 3:
                    cancelarReserva();
                    break;
                case 4:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
    }

    private static void exibirMenuFuncionario(){
        int opcao;
        do {
            System.out.println("Bem Vindo ao Sistema de Reservas!");
            System.out.println("1. Visualizar reservas");
            System.out.println("2. Adicionar acomodação");
            System.out.println("3. Remover acomodação");
            System.out.println("4. Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    visualizarReservas();
                    break;
                case 2:
                    adicionarAcomodacao();
                    break;
                case 3:
                    removerAcomodacao();
                    break;
                case 4:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
    }

    private static void pesquisarHoteis(){
        System.out.println("Funcao de pesquisa de hotéis ainda não implementada.");
    }

    private static void fazerReserva(){
        System.out.println("Funcao de reserva ainda não implementada.");
    }

    private static void cancelarReserva(){
        System.out.println("Funcao de cancelamento de reserva ainda não implementada.");
    }

    private static void adicionarAcomodacao(){
        System.out.println("Função de adicionar acomodação ainda não implementada.");
    }

    private static void removerAcomodacao(){
        System.out.println("Função de remover acomodação ainda não implementada.");
    }

    private static void visualizarReservas(){
        System.out.println("Função de visualizar reservas ainda não implementada.");
    }
}
