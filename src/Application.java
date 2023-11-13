import Core.MovieRentalSystem;
import Models.Customer;
import Models.Movie;
import Models.RentalItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MovieRentalSystem movieRentalSystem = new MovieRentalSystem();

        //Creando peliculas
        List<RentalItem> rentalItems =List.of(
          new Movie("Five Nights at Freddy’s", 1, true, "Emma Tammi", 109, "PG-13", "Horror Mistery "),
                new Movie("Avatar: The Way of Water", 2, true, "James Cameron", 192, "PG-13", "Action Adventure Fantasy"),
                new Movie("Top Gun: Maverick", 3, true, "Joseph Kosinski", 131, "PG-13", "Action Drama"),
                new Movie("Jurassic World: Dominion", 4, true, "Colin Trevorrow", 130, "PG-13", "Action Adventure Sci-Fi"),
                new Movie("Doctor Strange in the Multiverse of Madness", 5, true, "Sam Raimi", 132, "PG-13", "Action Adventure Fantasy"),
                new Movie("Minions: The Rise of Gru", 6, true, "Kyle Balda", 96, "PG", "Animation Adventure Comedy"),
                new Movie("Black Panther: Wakanda Forever", 7, true, "Ryan Coogler", 134, "PG-13", "Action Adventure Drama"),
                new Movie("The Batman", 8, true, "Matt Reeves", 176, "PG-13", "Action Crime Drama"),
                new Movie("Thor: Love and Thunder", 9, true, "Taika Waititi", 130, "PG-13", "Action Adventure Comedy"),
                new Movie("Shazam! Fury of the Gods", 10, true, "David F. Sandberg", 130, "PG-13", "Action Adventure Fantasy"),
                new Movie("Ant-Man and the Wasp: Quantumania", 11, true, "Peyton Reed", 124, "PG-13", "Action Adventure Sci-Fi"),
                new Movie("Susy: una vedette en el Congreso", 12, true, "Liliana Álvarez", 90, "PG-13", "Comedy")
        );

        //Creando usuarios
        List<Customer> customers = List.of(
                new Customer("Jorge Fernandez", 1, new ArrayList<>()),
                new Customer("Maria Rodriguez", 2, new ArrayList<>()),
                new Customer("Carlos Ramirez", 3, new ArrayList<>()),
                new Customer("Ana Torres", 4, new ArrayList<>()),
                new Customer("Luis Morales", 5, new ArrayList<>()),
                new Customer("Sofia Guzman", 6, new ArrayList<>()),
                new Customer("Miguel Herrera", 7, new ArrayList<>()),
                new Customer("Gabriela Peña", 8, new ArrayList<>()),
                new Customer("Diego Diaz", 9, new ArrayList<>()),
                new Customer("Isabella Castillo", 10, new ArrayList<>())
        );

        movieRentalSystem.setRentalItems(rentalItems);
        movieRentalSystem.setCustomers(customers);

        Scanner sc = new Scanner(System.in);

        //mostrando opciones del menu
        while(true){
            System.out.println("Bienvenido al Sistema de Renta de Peliculas ");
            System.out.println("--------------------------------------------");
            System.out.println("Ingrese 1 para ver las películas a rentar");
            System.out.println("Ingrese 2 para ver los usuarios");
            System.out.println("Ingrese 3 para ver la información de una película");
            System.out.println("Ingrese 4 para ver la información de un usuario");
            System.out.println("Ingrese 5 para rentar una película");
            System.out.println("Ingrese 6 para devolver una película");
            System.out.println("--------------------------------------------");

            int option = sc.nextInt();
            int idCustomer = 0;
            String itemName = "";
            switch (option){
                case 1:
                    movieRentalSystem.showAllItems();
                    break;
                case 2:
                    movieRentalSystem.showAllCustomers();
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la película");
                    itemName = sc.next();
                    movieRentalSystem.findRentalItem(itemName);
                    break;
                case 4:
                    System.out.println("Ingrese el idCustomer del cliente");
                    idCustomer = sc.nextInt();
                    movieRentalSystem.findRentalCustomer(idCustomer);
                    break;
                case 5:
                    System.out.println("Ingrese el idCustomer del cliente");
                    idCustomer = sc.nextInt();
                    System.out.println("Ingrese el nombre de la película");
                    itemName = sc.next();
                    movieRentalSystem.rentMovieToCustomer(idCustomer, itemName);
                    break;
                case 6:
                    System.out.println("Ingrese el idCustomer del cliente");
                    idCustomer = sc.nextInt();
                    System.out.println("Ingrese el nombre de la película");
                    itemName = sc.next();
                    movieRentalSystem.returnMovie(idCustomer, itemName);
                    break;
            }
        }

    }
}