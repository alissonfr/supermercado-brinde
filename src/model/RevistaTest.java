package model;

import java.util.Date;

public class RevistaTest {
    private String titulo;
    private int numeroDeEdicao;
    private int numeroDeVolume;
    private int quantidadeDeRevistas;
    private Date data;

    public RevistaTest(int tamanho) {

    }

    public RevistaTest(String titulo, int numeroDeEdicao, int numeroDeVolume) {
        this.titulo = titulo;
        this.numeroDeEdicao = numeroDeEdicao;
        this.numeroDeVolume = numeroDeVolume;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroDeEdicao() {
        return numeroDeEdicao;
    }

    public void setNumeroDeEdicao(int numeroDeEdicao) {
        this.numeroDeEdicao = numeroDeEdicao;
    }

    public Date getMesEAnoDePublicacao() {
        return data;
    }

    public void setMesEAnoDePublicacao(Date mesEAnoDePublicacao) {
        this.data = mesEAnoDePublicacao;
    }

    public int getNumeroDeVolume() {
        return numeroDeVolume;
    }

    public void setNumeroDeVolume(int numeroDeVolume) {
        this.numeroDeVolume = numeroDeVolume;
    }

    public int getQuantidadeDeRevistas() {
        return quantidadeDeRevistas;
    }

    public void setQuantidadeDeRevistas(int quantidadeDeRevistas) {
        this.quantidadeDeRevistas = quantidadeDeRevistas;
    }

    @Override
    public String toString() {
        return  "Titulo: " + this.titulo +
                "; Número de edição " + this.numeroDeEdicao +
                "; Número de volume: " + this.numeroDeVolume;
    }

}
