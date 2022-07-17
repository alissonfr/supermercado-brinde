package model;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    public static void main(String args[]){

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

@Override
    public String toString() {
        return  "id: " + this.getId() +
                "\nNome: " + this.getName() +
                "\nPreco: " + Utils.doubleToString(this.getPrice());
    }
}
