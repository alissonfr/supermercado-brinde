package main;

import model.Produto;
import model.Revista;
import utils.Utils;
import utils.dataHora;

import java.util.*;

public class Mercado {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Revista> revistas;
    private static ArrayList<Produto> produtos;
    private static Stack<Revista> pilha;
    private static Map<Produto, Integer> carrinho;
    static String stackedAt = dataHora.getDate();
    public static void main (String[] args) {

        revistas = new ArrayList<Revista>();

        pilha = new Stack<Revista>();

        produtos = new ArrayList<Produto>();
        Produto produto1 = new Produto("Leite 1L", 39.99);
        Produto produto2 = new Produto("Carne 1Kg", 60.99);
        produtos.add(produto1);
        produtos.add(produto2);

        carrinho = new HashMap<>();
        menu();
    }

    public static void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("-----------Bem-vindo ao Supermercado!-----------");
        System.out.println("------------------------------------------------");
        System.out.println("**************** Se Identifique ****************");
        System.out.println("|      Opcao 1 - Cliente           |");
        System.out.println("|      Opcao 2 - Funcionario       |");
        System.out.println("|      Opcao 3 - Sair              |");

        int option = input.nextInt();

        switch (option) {
            case 1:
                menuCliente();
                break;
            case 2:
                menuAdministrador();
                break;
            case 3:
                System.out.println("Obrigado pela preferencia! Volte sempre.");
                System.exit(0);
                break;
            default:
                System.out.println("Opcao Invalida!");
                menu();
                break;
        }
    }
    public static void menuCliente() {
        System.out.println("************ Selecione uma operacao ************");
        System.out.println("|    Opcao 1 - Produtos Disponiveis   |");
        System.out.println("|    Opcao 2 - Comprar                |");
        System.out.println("|    Opcao 3 - Carrinho               |");
        System.out.println("|    Opcao 4 - Voltar                 |");
        System.out.println("|    Opcao 5 - Sair                   |");

        int option = input.nextInt();

        switch (option) {
            case 1:
                listarProdutos();
                break;
            case 2:
                comprarProdutos();
                break;
            case 3:
                verCarrinho();
                break;
            case 4:
                menu();
                break;
            case 5:
                System.out.println("Obrigado pela preferencia! Volte sempre.");
                System.exit(0);
                break;
            default:
                System.out.println("Opcao Invalida!");
                menuCliente();
                break;
        }
    }

    public static void menuAdministrador() {
        System.out.println("************ Selecione uma operacao ************");
        System.out.println("|     Opcao 1 - Cadastrar Revista     |");
        System.out.println("|     Opcao 2 - Apagar Revista        |");
        System.out.println("|     Opcao 3 - Listar Revistas       |");
        System.out.println("|     Opcao 4 - Voltar                |");
        System.out.println("|     Opcao 5 - Sair                  |");

        int option = input.nextInt();

        switch (option) {
            case 1:
                cadastrarRevista();
                break;
            case 2:
                apagarRevista();
                break;
            case 3:
                listarRevistas();
                break;
            case 4:
                menu();
                break;
            case 5:
                System.out.println("Obrigado pela preferencia! Volte sempre.");
                System.exit(0);
                break;
            default:
                System.out.println("Opcao Invalida!");
                menuAdministrador();
                break;
        }
    }

    private static void cadastrarRevista() {
        System.out.print("Titulo da Revista (sem espaços): ");
        String title = input.next(); // TODO: BUG, NÃO ACEITA ESPAÇOS (??)

        System.out.println("Edicao da Revista: ");
        int edition = input.nextInt();

        System.out.println("Data de Publicacao da Revista: ");
        String publishedAt = input.next();

        System.out.println("Volume da Revista: ");
        int volume = input.nextInt(); // TODO: BUG, NÃO ACEITA ESPAÇOS (??)

        Revista revista = new Revista(title, edition, publishedAt, volume, stackedAt);
        pilha.push(revista);

        System.out.println(revista.getTitle() + " cadastrado com sucesso!");
        menuAdministrador();
    }
    private static void apagarRevista() {
        System.out.println(
                "A Revista: '" + pilha.peek().getTitle() + "' foi removida da pilha" + " as " + stackedAt + " com sucesso!");
        pilha.pop();
        menuAdministrador();
    }

    private static void listarProdutos() {
        if (produtos.size() > 0) {
            System.out.println("Lista de produtos: \n");

            for (Produto p : produtos) {
                System.out.println(p + "\n-------------------");
            }
        } else {
            System.out.println("Nenhum produto cadastrado!");
        }

        menuCliente();
    }

    private static void listarRevistas() { // TODO: VERIFICAR POR QUE NAO FUNCIONA!!
        if (pilha.size() > 0) {
            System.out.println("Lista de revistas: \n");

            for (Revista p : revistas) {
                System.out.println(p);
            }
        } else {
            System.out.println("Nenhuma revista cadastrado!");
        }

        menuAdministrador();
    }

    private static void comprarProdutos() {
        if (produtos.size() > 0) {
            System.out.println("Codigo do produto: \n");

            System.out.println("----------Produtos Disponiveis----------");
            for (Produto p : produtos) {
                System.out.println(p + "\n");
            }

            int id = Integer.parseInt(input.next());
            boolean isPresent = false;

            if (id > produtos.size()) {
                System.out.println("Produto não encontrado!");
            }

            for (Produto p : produtos) {
                if (p.getId() == id) {
                    int qtd = 0;
                    try {
                        qtd = carrinho.get(p);
                        // se o produto ja estiver no carrinho e incrementa quantidade.
                        carrinho.put(p, qtd +1);
                    }catch (NullPointerException e) {
                        // se o produto for o primeiro do carrinho.
                        carrinho.put(p, 1);
                    }

                    System.out.println(p.getName() + " foi adicionado ao carrinho!");
                    isPresent = true;

                    if (isPresent) {
                        System.out.println("Deseja adicionar outro produto ao carrinho? ");
                        System.out.println("Digite 1 para sim, ou 0 para finalizar a compra. ");
                        int option = Integer.parseInt(input.next());

                        if (option == 1) {
                            comprarProdutos();
                        } else {
                            finalizarCompra();
                        }
                    }
                }
            }
        } else {
            System.out.println("Não existem produtos cadastrados!. ");
            menuCliente();
        }
    }

    private static void verCarrinho() {
        System.out.println("----------Produtos no carrinho----------");
        if (carrinho.size() > 0) {
            for (Produto p : carrinho.keySet()) {
                System.out.println(
                        "Produto: " + p +
                        "\nQuantidade: " + carrinho.get(p)
                );
            }
        } else {
            System.out.println("Carrinho vazio!");
        }

        menuCliente();
    }

    private static void finalizarCompra() {
        Double valorDaCompra = 0.0;
        System.out.println("Seus produtos!");

        for (Produto p : carrinho.keySet()) {
            int qtd = carrinho.get(p);
            valorDaCompra += p.getPrice() * qtd;
            System.out.println(p);
            System.out.println(
                    "Quantidade: " + qtd

            );
            System.out.println("--------------------");
        }
        System.out.println(
                "Valor das suas compras: " + Utils.doubleToString(valorDaCompra) +
                        "\nVoce ganhou a revista: " + pilha.peek()
        );
        apagarRevista();
        carrinho.clear();
        System.out.println("Obrigado pela preferencia! Volte sempre.");
        menu();
    }
}
