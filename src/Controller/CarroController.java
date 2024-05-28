package Controller;

import java.util.ArrayList;
import java.util.List;
import model.Carro;

public class CarroController {
    private List<Carro> carros;

    public CarroController() {
        this.carros = new ArrayList<>();
        cadastrarCarros();
    }

    private void cadastrarCarros() {
        carros.add(new Carro("Toyota", "Corolla", 2020, 15000, "Sedan", "LMN-0123", 90000.00));
        carros.add(new Carro("Volkswagen", "Golf", 2018, 30000, "Hatchback", "DEF-8901", 111000.00));
        carros.add(new Carro("Ford", "Mustang", 2021, 5000, "Esportivo", "GHI-4567", 450000.00));
        carros.add(new Carro("Chevrolet", "S10", 2019, 25000, "Caminhonete", "VWX-7890", 130000.00));
        carros.add(new Carro("Honda", "Civic", 2017, 40000, "Sedan", "STU-3456", 95000.00));
        carros.add(new Carro("BMW", "X5", 2022, 8000, "SUV", "PQR-6789", 500000.00));
        carros.add(new Carro("Mercedes-Benz", "A-Class", 2020, 20000, "Hatchback", "MNO-2345", 200000.00));
        carros.add(new Carro("Jeep", "Renegade", 2019, 35000, "SUV", "JKL-5678", 73000.00));
        carros.add(new Carro("Audi", "A4", 2018, 28000, "Sedan", "XYZ-9876", 120000.00));
        carros.add(new Carro("Hyundai", "Creta", 2021, 10000, "SUV", "ABC-1234", 90000.00));
    }

    public void listarCarros() {
        for (Carro carro : carros) {
            System.out.println(carro);
        }
    }

    public static void main(String[] args) {
        CarroController automovel = new CarroController();
        automovel.listarCarros();
    }
}