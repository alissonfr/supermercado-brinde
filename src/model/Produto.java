/*package model;

import utils.Utils;

public class Produto {
    public static void main(String args[]){
        Produtos[] arr = new Produtos[2];
        arr[0] = new Produtos("Produto 1", 10.99);
        arr[1] = new Produtos("Produto 2", 66.99);
        arr[0].display();
        arr[1].display();

    }

    private static int count = 1;
    private int id;
    private String name;
    private double price;
}

class Produtos {


    public Produtos(String name, double price) {
        this.id = count;
        this.name = name;
        this.price = price;
        Produtos.count += 1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display(){
        System.out.println(
                        "id: " + id +
                        "\nNome do Produto: " + name +
                        "\nPreço: " + Utils.doubleToString(price)
        );
    }
} */

package model;

import utils.Utils;

public class Produto {
    public static void main(String args[]){
        Produto[] arr = new Produto[2];
        arr[0] = new Produto("Produto 1", 10.99);
        arr[1] = new Produto("Produto 2", 66.99);

    }
    private static int count = 1;

    private int id;
    private String name;
    private Double price;

    public Produto(String name, Double price) {
        this.id = count;
        this.name = name;
        this.price = price;
        Produto.count += 1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString() {
        return  "id: " + this.getId() +
                "\nNome: " + this.getName() +
                "\nPreco: " + Utils.doubleToString(this.getPrice());
    }
}
