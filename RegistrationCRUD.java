package com.adv_JDBC.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RegistrationCRUD {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/in18";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Anil1819";

	public static void createRegistration(String name, String email, int age, String phone, String address) {
		String query = "INSERT INTO Registration (Name, Email, age, PhoneNumber, Address) VALUES (?, ?, ?, ?, ?)";

		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = con.prepareStatement(query)) {

			statement.setString(1, name);
			statement.setString(2, email);
			statement.setInt(3, age); 
			statement.setString(4, phone);
			statement.setString(5, address);

			int rowsInserted = statement.executeUpdate();
			System.out.println(rowsInserted + " registration(s) created successfully.");

		} catch (SQLException e) {
			System.out.println("Error creating registration: " + e.getMessage());
		}
	}

	public static void readRegistrations() {
		String query = "SELECT * FROM Registration";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)) {

			while (resultSet.next()) {
				System.out.println("ID: " + resultSet.getInt("ID"));
				System.out.println("Name: " + resultSet.getString("Name"));
				System.out.println("Email: " + resultSet.getString("Email"));
				System.out.println("Age: " + resultSet.getInt("age"));
				System.out.println("Phone: " + resultSet.getString("PhoneNumber"));
				System.out.println("Address: " + resultSet.getString("Address"));
				System.out.println("Registered At: " + resultSet.getTimestamp("RegisteredAt"));
				System.out.println("------------------------------");
			}

		} catch (SQLException e) {
			System.out.println("Error reading registrations: " + e.getMessage());
		}
	}

	public static void updateRegistration(int id, String name, String email, int age, String phone, String address) {
		String query = "UPDATE Registration SET Name = ?, Email = ?, age = ?, PhoneNumber = ?, Address = ? WHERE ID = ?";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, name);
			statement.setString(2, email);
			statement.setInt(3, age);
			statement.setString(4, phone);
			statement.setString(5, address);
			statement.setInt(6, id);

			int rowsUpdated = statement.executeUpdate();
			System.out.println(rowsUpdated + " registration(s) updated successfully.");

		} catch (SQLException e) {
			System.out.println("Error updating registration: " + e.getMessage());
		}
	}

	public static void deleteRegistration(int id) {
		String query = "DELETE FROM Registration WHERE ID = ?";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setInt(1, id);

			int rowsDeleted = statement.executeUpdate();
			System.out.println(rowsDeleted + " registration(s) deleted successfully.");

		} catch (SQLException e) {
			System.out.println("Error deleting registration: " + e.getMessage());
		}
	}


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Select An option");
		System.out.println("1.Create Registration\n2.Read Registrations\n3.Update Registration\n4.Delete Registration");
		int n = sc.nextInt();
		switch(n)
		{
		case 1:
				System.out.println("Enter Name, Email, Age, Phone, Address");
				createRegistration(sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.nextLine());
				break;
		case 2: 
				readRegistrations();
				break;
		case 3: 
				System.out.println("Enter Id, Name, Email, Age, Phone, Address to update");
				updateRegistration(sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.nextLine());
				break;
		case 4:
				System.out.println("Enter Id to delete");
				deleteRegistration(sc.nextInt());
			
		default:
				System.out.println("you are not selected above option");
		}
		
		
		
	}

}
