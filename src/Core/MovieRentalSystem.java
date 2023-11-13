package Core;

import Models.Customer;
import Models.Movie;
import Models.RentalItem;

import java.util.ArrayList;
import java.util.List;

public class MovieRentalSystem {
    private List<RentalItem> rentalItems;
    private List<Customer> customers;
    public MovieRentalSystem(){
        this.rentalItems = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public List<RentalItem> getRentalItems() {
        return rentalItems;
    }

    public void setRentalItems(List<RentalItem> rentalItems) {
        this.rentalItems = rentalItems;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public boolean addItem(int id, RentalItem rentalItem){
        for(Customer customer: this.customers){
            if(customer.getCustomerID() == id){
                this.rentalItems.add(rentalItem);
                return true;
            }
        }
        return false;
    }

    public boolean registerCustomer(Customer customer){
        this.customers.add(customer);
        return true;
    }

    public Customer validateCustomer(int id){
        //verificamos si existe el usuario
        Customer customerFound = null;
        for(Customer customer: this.customers){
            if(customer.getCustomerID() == id){
                customerFound = customer;
                break;
            }
        }
        if (customerFound != null){
            return customerFound;
        }
        else {
            System.out.println("Cliente no encontrado");
            return null;
        }
    }

    public RentalItem validateRentalItem(int id){
        //verificamos si existe la pelicula
        RentalItem rentalItemFound = null;
        for(RentalItem rentalItem: this.rentalItems){
            if(rentalItem.getItemID() == id){
                rentalItemFound = rentalItem;
                break;
            }
        }
        if(rentalItemFound != null) {
            return rentalItemFound;
        } else {
            System.out.println("Item no encontrado");
            return null;
        }
    }
    public void rentMovieToCustomer(int idCustomer, int idRentalItem){
        Customer customerFound = validateCustomer(idCustomer);
        if (customerFound == null) return;

        RentalItem rentalItemFound = validateRentalItem(idRentalItem);
        if (rentalItemFound == null) return;

        //verificamos si la pelicula esta disponible
        if (rentalItemFound.isAvailable()){
            customerFound.addRentedMovie((Movie) rentalItemFound);
            rentalItemFound.setAvailable(false);
            System.out.println("Pelicula rentada al cliente exitosamente");
        } else {
            System.out.println("Pelicula no disponible");
        }
    }

    public void returnMovie(int idCustomer, int idRentalItem){
        Customer customerFound = validateCustomer(idCustomer);
        if (customerFound == null) return;

        RentalItem rentalItemFound = validateRentalItem(idRentalItem);
        if (rentalItemFound == null) return;

        //verificamos si la pelicula esta disponible
        if (!rentalItemFound.isAvailable()){
            customerFound.removeRentedMovie((Movie) rentalItemFound);
            rentalItemFound.setAvailable(true);
            System.out.println("Pelicula devuelta exitosamente");
        }
    }

    public void showAllItems(){
        for(RentalItem rentalItem: this.rentalItems){
            rentalItem.showDetails();
        }
    }

    public void showAllCustomers(){
        for(Customer customer: this.customers){
            customer.showDetails();
        }
    }

    public void findRentalItem(int idRentalItem){
        RentalItem itemFound = null;
        for(RentalItem rentalItem: this.rentalItems){
            if(rentalItem.getItemID() == idRentalItem){
                itemFound = rentalItem;
                break;
            }
        }
        if(itemFound != null){
            itemFound.showDetails();
        } else {
            System.out.println("Item no encontrado");
        }
    }

    public void findRentalCustomer(int id){
        Customer customerFound = null;
        for(Customer customer: this.customers){
            if(customer.getCustomerID() == id){
                customerFound = customer;
                break;
            }
        }
        if (customerFound != null) {
            customerFound.showDetails();
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
}
