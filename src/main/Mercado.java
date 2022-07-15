package main;

import model.Produto;
import model.Revista;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mercado {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Revista> revistas;
    private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho;

    public static void main (String[] args) {
        revistas = new ArrayList<Revista>();
        produtos = new ArrayList<Produto>();
        carrinho = new HashMap<Produto, Integer>();
        menu();
    }

    public static void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("-----------Bem-vindo ao Supermercado!-----------");
        System.out.println("------------------------------------------------");
        System.out.println("************ Selecione uma operacao ************");
        System.out.println("|    Opcao 1 - Produtos Disponiveis   |");
        System.out.println("|    Opcao 2 - Comprar                |");
        System.out.println("|    Opcao 3 - Carrinho               |");
        System.out.println("************** Modo administrador **************");
        System.out.println("|     Opcao 4 - Cadastrar Revista     |");
        System.out.println("|     Opcao 5 - Listar Revistas       |");
        System.out.println("|     Opcao 6 - Sair                  |");

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
                cadastrarRevistas();
                break;
            case 5:
                listarRevistas();
                break;
            case 6:
                System.out.println("Obrigado pela preferencia! Volte sempre.");
                System.exit(0);
                break;
            default:
                System.out.println("Opcao Invalida!");
                menu();
                break;
        }
    }

    private static void cadastrarRevistas() {
        System.out.println("Titulo da Revista: ");
        String title = input.next();

        System.out.println("Edicao da Revista: ");
        int edition = input.nextInt();

        System.out.println("Data de Publicacao da Revista: ");
        String publishedAt = input.next();

        System.out.println("Volume da Revista: ");
        int volume = input.nextInt();

        Revista revista = new Revista(title, edition, publishedAt, volume);
        revistas.add(revista);

        System.out.println(revista.getTitle() + " cadastrado com sucesso!");
        menu();
    }

    private static void listarProdutos() {
        if (produtos.size() > 0) {
            System.out.println("Lista de produtos: \n");

            for (Produto p : produtos) {
                System.out.println(p);
            }
        } else {
            System.out.println("Nenhum produto cadastrado!");
        }

        menu();
    }

    private static void listarRevistas() {
        if (revistas.size() > 0) {
            System.out.println("Lista de revistas: \n");

            for (Revista p : revistas) {
                System.out.println(p);
            }
        } else {
            System.out.println("Nenhuma revista cadastrado!");
        }

        menu();
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
                } else {
                    System.out.println("Produto nao encontrado. ");
                    menu();
                }
            }
        } else {
            System.out.println("Não existem produtos cadastrados!. ");
            menu();
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

        menu();
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
        System.out.println("Valor das suas compras: " + Utils.doubleToString(valorDaCompra));
        carrinho.clear();
        System.out.println("Obrigado pela preferencia! Volte sempre.");
        menu();
    }
}
