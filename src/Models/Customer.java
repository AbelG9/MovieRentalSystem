package Models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private int customerID;
    private List<Movie> rentedMovies;

    public Customer(String customerName, int customerID, List<Movie> rentedMovies) {
        this.customerName = customerName;
        this.customerID = customerID;
        this.rentedMovies = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public List<Movie> getRentedMovies() {
        return rentedMovies;
    }

    public void setRentedMovies(List<Movie> rentedMovies) {
        this.rentedMovies = rentedMovies;
    }

    public boolean addRentedMovie(Movie movie){
        this.rentedMovies.add(movie);
        return true;
    }

    public boolean removeRentedMovie(Movie movie){
        this.rentedMovies.remove(movie);
        return true;
    }

    public void showDetails(){
        System.out.println("Customer Name :" + this.customerName);
        System.out.println("Customer ID :" + this.customerID);
        System.out.println("Rented Movies :" + this.rentedMovies);
    }
}
