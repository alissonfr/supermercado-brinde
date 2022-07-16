package model;

import utils.Utils;

public class Revista {
    private static int count = 1;

    private int id;
    private String title;
    private int edition;
    private String publishedAt;
    private int volume;
    private String stackedAt;


    public Revista(String title, int edition, String publishedAt, int volume, String stackedAt) {
        this.id = count;
        this.title = title;
        this.edition = edition;
        this.publishedAt = publishedAt;
        this.volume = volume;
        this.stackedAt = stackedAt;
        Revista.count += 1;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getStackedAt() {
        return stackedAt;
    }

    public void setStackedAt(String stackedAt) {
        this.stackedAt = stackedAt;
    }

    @Override
    public String toString() {
        return  "id: " + this.getId() +
                "\nTitulo: " + this.getTitle() +
                "\nEdicao: " + this.getEdition() +
                "\nPublicado em: " + this.getPublishedAt() +
                "\nVolume: " + this.getVolume() +
                "\nAdicionado a pilha em: " + this.getStackedAt();

    }
}