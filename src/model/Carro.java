package model;

public class Carro {
    private int Id;
    private String marca;
    private String modelo;
    private int ano;
    private int quilometragem;
    private String categoria;
    private String placa;
    private Double preco;

    public Carro(int Id, String marca, String modelo, int ano, int quilometragem, String categoria, String placa, Double preco) {
        this.Id = Id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.categoria = categoria;
        this.placa = placa;
        this.preco = preco;
    }

    // Getters
        public int getId() {
        return Id;
    }
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getPlaca() {
        return placa;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return Id + " " + marca + " " + modelo + " (" + ano + ") - " + quilometragem + "km - " + categoria + " - Placa: " + placa;
    }
}
