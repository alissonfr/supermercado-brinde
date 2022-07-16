package model;

import java.util.ArrayList;
// CLASSE TESTE
// TODO: TENTAR PASSAR LISTA DE PRODUTOS POR ESSA CLASSE E NAO NO MAIN
public class ProdutosTotal extends Produto {
    public ProdutosTotal(String name, double price) {
        super(name, price);

    }

    public static Object ProdutosT() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();

        Produto produto1 = new Produto("Açúcar Refinado", 2.15);
        Produto produto2 = new Produto("Água Sanitária", 3.98 );
        Produto produto3 = new Produto("Amaciante", 11.58);

        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);



        return produtos;
    }

}
