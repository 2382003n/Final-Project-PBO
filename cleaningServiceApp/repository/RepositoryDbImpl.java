package cleaningServiceApp.repository;


import cleaningServiceApp.config.Database;
import cleaningServiceApp.entities.Customer;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class RepositoryDbImpl implements Repository {

    Database database;

    public RepositoryDbImpl(Database database) {
        this.database = database;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Connection connection = database.getConnection();
        String sqlStatement = "INSERT INTO customers(name, address, phone) VALUES(?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddreas());
            preparedStatement.setString(3, customer.getPhone());


            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer saved successfully!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Customer> getCustomer() {
        Connection connection = database.getConnection();
        String sqlStatement = "SELECT * FROM customers";
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                String nama = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");

                Customer customer = new Customer(nama,address,phone);
                customers.add(customer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return customers;
    }

    @Override
    public double calculateTotalPrice() {
        return 0;
    }

    @Override
    public void addPackagePrice(double price) {

    }
}

