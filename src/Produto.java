public class Produto implements Compravel {
    int produto_id;
    int cliente_id;




    @Override
    public boolean comprar(int produto_id, int cliente_id) {
        System.out.println(produto_id + cliente_id);
        return false;
    }
}
