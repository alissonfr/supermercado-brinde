package model;

import utils.Utils;

public class Revista {
    private static int count = 1;

    private int id;
    private String title;
    private int edition;
    private String publishedAt;
    private int volume;


    public Revista(String title, int edition, String publishedAt, int volume) {
        this.id = count;
        this.title = title;
        this.edition = edition;
        this.publishedAt = publishedAt;
        this.volume = volume;
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

    public String toString() {
        return  "id: " + this.getId() +
                "\nTitulo: " + this.getTitle() +
                "\nEdicao: " + this.getEdition() +
                "\nPublicado em: " + this.getPublishedAt() +
                "\nVolume: " + this.getVolume();

    }
}