package main;

import model.Produto;
import model.Revista;
import utils.Utils;
import utils.DataHora;
import java.time.LocalTime;
import java.util.*;
import java.util.Scanner;

public class Mercado {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Revista> revistas;
    private static ArrayList<Produto> produtos;
    private static Stack<Revista> pilha;
    private static Map<Produto, Integer> carrinho;

    public static void main (String[] args) throws InterruptedException {

        revistas = new ArrayList<Revista>();

        pilha = new Stack<Revista>();

        produtos = new ArrayList<Produto>();
        Produto produto1 = new Produto("Açúcar Refinado", 2.15);
        Produto produto2 = new Produto("Água Sanitária", 3.98 );
        Produto produto3 = new Produto("Amaciante", 11.58);
        Produto produto4 = new Produto("Arroz Branco", 13.98);
        Produto produto5 = new Produto("Azeite Tipo Extravirgem", 17.90);
        Produto produto6 = new Produto("Barra de Chocolate", 5.99);
        Produto produto7 = new Produto("Bolacha Recheada de Chocolate", 1.88);
        Produto produto8 = new Produto("Bombons Sortidos", 7.98);
        Produto produto9 = new Produto("Café em Pó Tradicional", 11.88);
        Produto produto10 = new Produto("Cerveja 350ml", 2.39);
        Produto produto11 = new Produto("Cerveja 500ml", 12.70);
        Produto produto12 = new Produto("Creme de Avelã", 17.90);
        Produto produto13 = new Produto("Creme de Leite", 2.49);
        Produto produto14 = new Produto("Detergente Líquido Incolor", 1.39);
        Produto produto15 = new Produto("Extrato de Tomate", 3.74);
        Produto produto16 = new Produto("Farinha de Trigo", 2.28);
        Produto produto17 = new Produto("Feijão", 3.28);
        Produto produto18 = new Produto("Gim", 89.90);
        Produto produto19 = new Produto("Hambúrguer de Frango e Boi", 12.75);
        Produto produto20 = new Produto("Iogurte de Morango", 3.99);
        Produto produto21 = new Produto("Lã de Aço", 1.86);
        Produto produto22 = new Produto("Leite Condensado", 3.98);
        Produto produto23 = new Produto("Leite UHT Integral", 2.18);
        Produto produto24 = new Produto("Macarrão com Ovos Parafuso", 2.65);
        Produto produto25 = new Produto("Macarrão Espaguete", 6.49);
        Produto produto26 = new Produto("Maionese", 4.98);
        Produto produto27 = new Produto("Nuggets Tradicional", 5.98);
        Produto produto28 = new Produto("Óleo de Soja", 3.10);
        Produto produto29 = new Produto("Pão de Forma Tradicional", 5.85);
        Produto produto30 = new Produto("Papel Higiênico", 6.45);
        Produto produto31 = new Produto("Refrigerante", 5.49);
        Produto produto32 = new Produto("Requeijão Cremoso Tradicional", 2.99);
        Produto produto33 = new Produto("Sabão em Pó", 7.99);
        Produto produto34 = new Produto("Sabonete", 1.22);
        Produto produto35 = new Produto("Sal Refinado", 2.19);
        Produto produto36 = new Produto("Sorvete Napolitano", 17.50);
        Produto produto37 = new Produto("Suco Pronto para Consumo Néctar", 4.92);
        Produto produto38 = new Produto("Uísque 12 Anos", 117.90);
        Produto produto39 = new Produto("Vodca", 29.90);

        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        produtos.add(produto5);
        produtos.add(produto6);
        produtos.add(produto7);
        produtos.add(produto8);
        produtos.add(produto9);
        produtos.add(produto10);
        produtos.add(produto11);
        produtos.add(produto12);
        produtos.add(produto13);
        produtos.add(produto14);
        produtos.add(produto15);
        produtos.add(produto16);
        produtos.add(produto17);
        produtos.add(produto18);
        produtos.add(produto19);
        produtos.add(produto20);
        produtos.add(produto21);
        produtos.add(produto22);
        produtos.add(produto23);
        produtos.add(produto24);
        produtos.add(produto25);
        produtos.add(produto26);
        produtos.add(produto27);
        produtos.add(produto28);
        produtos.add(produto29);
        produtos.add(produto30);
        produtos.add(produto31);
        produtos.add(produto32);
        produtos.add(produto33);
        produtos.add(produto34);
        produtos.add(produto35);
        produtos.add(produto36);
        produtos.add(produto37);
        produtos.add(produto38);
        produtos.add(produto39);

        carrinho = new HashMap<>();
        menu();
    }

    public static void menu() throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println("-----------Bem-vindo ao Supermercado!-----------");
        System.out.println("------------------------------------------------");
        System.out.println("**************** Identifique-se ****************");
        System.out.println("|      Opcao 1 - Cliente           |");
        System.out.println("|      Opcao 2 - Administrador     |");
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
                System.out.println("Obrigado pela preferência! Volte sempre.");
                System.exit(0);
                break;
            default:
                System.out.println("Opção Inválida!");
                menu();
                break;
        }
    }
    public static void menuCliente() throws InterruptedException {
        System.out.println("************ Selecione uma operação ************");
        System.out.println("|    Opcao 1 - Produtos Disponíveis   |");
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
                System.out.println("Obrigado pela preferência! Volte sempre.");
                System.exit(0);
                break;
            default:
                System.out.println("Opção Inválida!");
                menuCliente();
                break;
        }
    }

    public static void menuAdministrador() throws InterruptedException {
        System.out.println("************ Selecione uma operacao ************");
        System.out.println("|     Opcao 1 - Cadastrar Revista     |");
        System.out.println("|     Opcao 2 - Listar Revistas       |");
        System.out.println("|     Opcao 3 - Média de tempo        |");
        System.out.println("|     Opcao 4 - Voltar                |");
        System.out.println("|     Opcao 5 - Sair                  |");

        int option = input.nextInt();

        switch (option) {
            case 1:
                cadastrarRevista();
                break;
            case 2:
                listarRevistas();
                break;
            case 3:
//                mediaRevistas();
                break;
            case 4:
                menu();
                break;
            case 5:
                System.out.println("Obrigado pela preferência! Volte sempre.");
                System.exit(0);
                break;
            default:
                System.out.println("Opção Inválida!");
                menuAdministrador();
                break;
        }
    }

    private static void listarProdutos() throws InterruptedException {
        if (produtos.size() > 0) {
            System.out.println("Lista de produtos: \n");

            for (Produto p : produtos) {
                System.out.println(p + "\n-------------------");
            }
        } else {
            System.out.println("Nenhum produto cadastrado!");
        }
        Thread.sleep(5000);
        menuCliente();
    }

    private static void comprarProdutos() throws InterruptedException {
        if (produtos.size() > 0) {
            System.out.println("Código do produto: \n");

            System.out.println("----------Produtos Disponíveis----------");
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
                        // Se o produto ja estiver no carrinho e incrementa quantidade
                        carrinho.put(p, qtd +1);
                    }catch (NullPointerException e) {
                        // Se o produto for o primeiro do carrinho
                        carrinho.put(p, 1);
                    }

                    System.out.println(p.getName() + " foi adicionado ao carrinho!");
                    isPresent = true;

                    if (isPresent) {
                        System.out.println("Deseja adicionar outro produto ao carrinho? ");
                        System.out.println("Digite 1 para sim, 2 para finalizar a compra e 3 para voltar. ");
                        int option = Integer.parseInt(input.next());

                        switch (option) {
                            case 1:
                                comprarProdutos();
                                break;
                            case 2:
                                finalizarCompra();
                                break;
                            case 3:
                                menuCliente();
                                break;
                            default:
                                System.out.println("Opção Inválida!");
                                Thread.sleep(2000);
                                menuCliente();
                                break;
                        }
                    }
                }
            }
        } else {
            System.out.println("Não existem produtos cadastrados! ");
            Thread.sleep(2000);
            menuCliente();
        }
    }

    private static void finalizarCompra() throws InterruptedException {
        Double valorDaCompra = 0.0;
        System.out.println("Seus produtos!");

        for (Produto p : carrinho.keySet()) {
            int qtd = carrinho.get(p);
            valorDaCompra += p.getPrice() * qtd;
            System.out.println(p);
            System.out.println(
                    "Quantidade: " + qtd

            );
            System.out.println("----------------------------------------");
        }
        Thread.sleep(2000);

        int quantidadeRevistas = (int) (valorDaCompra/100);
        System.out.println("\n\nValor total das suas compras: " + Utils.doubleToString(valorDaCompra) +
                "\nVocê deve receber: " + quantidadeRevistas + " revistas!\n");
        carrinho.clear();

        if (!(valorDaCompra < 100)) {
            if (!pilha.empty()) {
                    apagarRevistaTopo(valorDaCompra);
                System.out.println("Obrigado pela preferência! Volte sempre.");
            } else {
                System.out.println("Você se enquadra na promoção porém, estamos sem revistas no momento! :(");
            }
        } else {
            System.out.println("Sua compra foi de menos de R$ 100,00, ou seja, você não se enquadra na promoção");
        }
    }

    private static void verCarrinho() throws InterruptedException {
        System.out.println("----------Produtos no carrinho----------");
        if (carrinho.size() > 0) {
            for (Produto p : carrinho.keySet()) {
                System.out.println(
                                "Produto: " + p +
                                "\nQuantidade: " + carrinho.get(p) +
                                "\n----------------------------------------"
                );
            }
        } else {
            System.out.println("Carrinho vazio!");
        }
        Thread.sleep(2000);
        menuCliente();
    }

    private static void cadastrarRevista() throws InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.print("Título da Revista: ");
        String title = input.nextLine();

        System.out.println("Edicão da Revista: ");
        int edition = input.nextInt();

        System.out.print("Data de Publicação da Revista: ");
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String publishedAt = scanner.next();

        System.out.println("Volume da Revista: ");
        int volume = input.nextInt();

        String stackedTime = DataHora.getTime(DataHora.getDateTime());
        String stackedDate = DataHora.getDate(DataHora.getDateTime());

        Revista revista = new Revista(title, edition, publishedAt, volume, stackedTime, stackedDate, 0);
        pilha.push(revista);

        System.out.println(
                "A revista: '" + revista.getTitle() + "' foi cadastrada com sucesso as: " + revista.getStackedTime() + " em " + revista.getStackedDate());
        Thread.sleep(2000);
        menuAdministrador();
    }

    private static void apagarRevistaTopo(double valorDaCompra) throws InterruptedException {
        if (valorDaCompra/100 >= pilha.size()){
            for (int quantidadeRevistas=(int) (valorDaCompra/100) ; quantidadeRevistas >= 1; quantidadeRevistas--) {
                String popedAt = DataHora.getDateTime();
                LocalTime stacked = LocalTime.parse(pilha.peek().getStackedTime());
                String dataAtual = DataHora.getTime(DataHora.getDateTime());

                String tempoPermanecido = DataHora.mostrar(stacked, dataAtual);
                int tempoPermanecidoSegundos = DataHora.dateToSeconds(tempoPermanecido);

                mediaRevistas(tempoPermanecidoSegundos);
                System.out.println(
                        "A REVISTA: \n"  +
                                pilha.peek() +
                                "\nFOI REMOVIDA DA PILHA COM SUCESSO EM: " +
                                popedAt +
                                "\nEla permaneceu: " + tempoPermanecido + " na pilha."+
                                "\n----------------------------------------");
                pilha.pop();
            }

            Thread.sleep(5000);
            menu();
        } else {
            System.out.println("Não temos revistas para a sua quantidade de compras! Tente novamente mais tarde. :(");
            System.exit(0);
        }
    }

    private static void listarRevistas() throws InterruptedException {
        if (!pilha.empty()) {
            for (Revista r : pilha) {
                System.out.println(r);
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("A pilha de revistas está vazia!");
        }
        menuAdministrador();
    }

    private static void mediaRevistas(int tempoPermanecidoSegundos) {
        System.out.println("Tempo médio de permanência das revistas: " + tempoPermanecidoSegundos);
    }

}
