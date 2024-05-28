package model;

public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private int quilometragem;
    private String categoria;
    private String placa;

    public Carro(String marca, String modelo, int ano, int quilometragem, String categoria, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.categoria = categoria;
        this.placa = placa;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + ano + ") - " + quilometragem + "km - " + categoria;
    }
    
}


