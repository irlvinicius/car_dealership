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
        carros.add(new Carro(1, "Toyota", "Corolla", 2020, 15000, "Sedan", "LMN-0123", 90000.00));
        carros.add(new Carro(2, "Volkswagen", "Golf", 2018, 30000, "Hatchback", "DEF-8901", 111000.00));
        carros.add(new Carro(3, "Ford", "Mustang", 2021, 5000, "Esportivo", "GHI-4567", 450000.00));
        carros.add(new Carro(4, "Chevrolet", "S10", 2019, 25000, "Caminhonete", "VWX-7890", 130000.00));
        carros.add(new Carro(5, "Honda", "Civic", 2017, 40000, "Sedan", "STU-3456", 95000.00));
        carros.add(new Carro(6, "BMW", "X5", 2022, 8000, "SUV", "PQR-6789", 500000.00));
        carros.add(new Carro(7, "Mercedes-Benz", "A-Class", 2020, 20000, "Hatchback", "MNO-2345", 200000.00));
        carros.add(new Carro(8, "Jeep", "Renegade", 2019, 35000, "SUV", "JKL-5678", 73000.00));
        carros.add(new Carro(9, "Audi", "A4", 2018, 28000, "Sedan", "XYZ-9876", 120000.00));
        carros.add(new Carro(10, "Hyundai", "Creta", 2021, 10000, "SUV", "ABC-1234", 90000.00));
        carros.add(new Carro(11, "Toyota", "Hilux", 2020, 20000, "Caminhonete", "HIJ-5678", 150000.00));
        carros.add(new Carro(12, "Volkswagen", "Fox", 2016, 50000, "Hatchback", "MNO-9876", 60000.00));
        carros.add(new Carro(13, "Ford", "Fiesta", 2019, 15000, "Hatchback", "PQR-1234", 55000.00));
        carros.add(new Carro(14, "Chevrolet", "Onix", 2017, 30000, "Hatchback", "STU-6789", 70000.00));
        carros.add(new Carro(15, "Honda", "Fit", 2018, 20000, "Hatchback", "ABC-4567", 80000.00));
        carros.add(new Carro(16, "BMW", "Série 3", 2022, 10000, "Sedan", "DEF-8901", 120000.00));
        carros.add(new Carro(17, "Mercedes-Benz", "C-Class", 2019, 25000, "Sedan", "GHI-2345", 130000.00));
        carros.add(new Carro(18, "Jeep", "Compass", 2020, 15000, "SUV", "JKL-6789", 110000.00));
        carros.add(new Carro(19, "Audi", "Q3", 2021, 12000, "SUV", "MNO-0123", 140000.00));
        carros.add(new Carro(20, "Hyundai", "HB20", 2018, 40000, "Hatchback", "PQR-4567", 65000.00));
        carros.add(new Carro(21, "Chevrolet", "Tracker", 2021, 10000, "SUV", "LMN-3456", 125000.00));
        carros.add(new Carro(22, "Honda", "City", 2019, 22000, "Sedan", "DEF-7890", 85000.00));
        carros.add(new Carro(23, "Toyota", "Yaris", 2020, 18000, "Hatchback", "GHI-1234", 80000.00));
        carros.add(new Carro(24, "Volkswagen", "T-Cross", 2021, 15000, "SUV", "JKL-9012", 115000.00));
        carros.add(new Carro(25, "Ford", "EcoSport", 2018, 30000, "SUV", "MNO-3456", 75000.00));
        carros.add(new Carro(26, "Hyundai", "i30", 2017, 25000, "Hatchback", "PQR-7890", 60000.00));
        carros.add(new Carro(27, "Audi", "TT", 2019, 12000, "Esportivo", "STU-1234", 200000.00));
        carros.add(new Carro(28, "BMW", "Série 1", 2020, 10000, "Hatchback", "ABC-5678", 90000.00));
        carros.add(new Carro(29, "Mercedes-Benz", "GLE", 2019, 18000, "SUV", "XYZ-1234", 160000.00));
        carros.add(new Carro(30, "Jeep", "Cherokee", 2022, 8000, "SUV", "DEF-6789", 140000.00));
    }

    public void listarCarros() {
        for (Carro carro : carros) {
            System.out.println(carro);
        }
    }

    public List<Carro> getCarros() {
        return carros;
    }


    public static void main(String[] args) {
        CarroController automovel = new CarroController();
        automovel.listarCarros();
    }
}