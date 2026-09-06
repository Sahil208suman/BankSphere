package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BankService {

    // View all customers
    public static void viewCustomers() {

        String sql = "SELECT * FROM customers";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                int customerId = resultSet.getInt("customer_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");

                System.out.println(
                    "ID: " + customerId +
                    " | Name: " + name +
                    " | Email: " + email +
                    " | Phone: " + phone
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View all accounts
    public static void viewAccounts() {

        String sql = "SELECT * FROM accounts";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println(
                    "Account ID: " + resultSet.getInt("account_id") +
                    " | Customer ID: " + resultSet.getInt("customer_id") +
                    " | Account Type: " + resultSet.getString("account_type") +
                    " | Balance: " + resultSet.getDouble("balance")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View all transactions
    public static void viewTransactions() {

        String sql = "SELECT * FROM transactions";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println(
                    "Transaction ID: " + resultSet.getInt("transaction_id") +
                    " | Account ID: " + resultSet.getInt("account_id") +
                    " | Type: " + resultSet.getString("transaction_type") +
                    " | Amount: " + resultSet.getDouble("amount") +
                    " | Date: " + resultSet.getTimestamp("transaction_date")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
