package com.sAdamingo.course.Task28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class PostgreSQLAdapter {
    public static void main(String[] args) {
        HashMapDatabase dataBase = new HashMapDatabase();
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/books",
                            "postgres", "adamek");
            c.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        int scenario = 0;
        while (scenario != 8) {
            try {
                switch (scenario) {
                    case 0 -> {
                        System.out.println("What do you want to do?\n[1] Show my DB\n[2]Add new element\n[3]Update id by given id\n[4]Update author by given id\n[5]Update title by given id\n[6]Delete element\n[7]EXIT PROGRAM");
                        scenario = Integer.parseInt(reader.readLine());
                    }
                    case 1 -> {
                        showDB(c, dataBase);
                        scenario = 0;
                    }
                    case 2 -> {
                        addToDB(c, dataBase);
                        scenario = 0;
                    }
                    case 3 -> {
                        updateIDByID(c, dataBase);
                        scenario = 0;
                    }
                    case 4 -> {
                        updateAuthorById(c, dataBase);
                        scenario = 0;
                    }
                    case 5 -> {
                        updateTitleById(c, dataBase);
                        scenario = 0;
                    }
                    case 6 -> {
                        deleteFromDB(c, dataBase);
                        scenario = 0;
                    }
                    case 7 -> {
                        c.close();
                        scenario = 8;
                    }
                }
            } catch (IOException | SQLException e) {
                System.err.println("An exception happened while you tried to perform an action: " + e.getMessage());
            }
        }
    }

    private static void deleteFromDB(Connection c, HashMapDatabase dataBase) throws IOException, SQLException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which position do you want to delete? Enter user_id");
        int id = Integer.parseInt(reader.readLine());
        dataBase.delete(id);
        String sql = "DELETE from my_book_shelf where user_id = ?;";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        c.commit();
    }

    public static void showDB(Connection c, HashMapDatabase dataBase) throws SQLException {
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM my_book_shelf ORDER BY user_id ASC;");
        while (rs.next()) {
            int id = rs.getInt("user_id");
            String author = rs.getString("author");
            String title = rs.getString("title");
            Timestamp created_on = rs.getTimestamp("created_on");
            Book position = new Book(id, author, title, created_on);
            dataBase.add(position);
            System.out.println(position);
            System.out.println();
        }
        rs.close();
        stmt.close();
    }

    public static void addToDB(Connection c, HashMapDatabase dataBase) throws SQLException, IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("You're about to add a new book position to a DB. What is its ID?");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Who is an author?");
        String author = reader.readLine();
        System.out.println("What is the title?");
        String title = reader.readLine();
        Book bookToAdd = new Book(id, author, title);
        dataBase.add(bookToAdd);
        String sql = "INSERT INTO my_book_shelf(user_id, author, title, created_on) " +
                "VALUES(?, ?, ?, ?);";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.setString(2, author);
        pstmt.setString(3, title);
        pstmt.setTimestamp(4, bookToAdd.getCreatedOn());
        pstmt.executeUpdate();
        c.commit();
    }

    public static void updateIDByID(Connection c, HashMapDatabase dataBase) throws SQLException, IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which position do you want to update? Enter user_id");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Enter new id");
        int newId = Integer.parseInt(reader.readLine());
        dataBase.get(id).setId(newId);
        String sql = "UPDATE my_book_shelf set user_id = ? where user_id=" + id + ";";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, newId);
        pstmt.execute();
        c.commit();
    }

    public static void updateAuthorById(Connection c, HashMapDatabase dataBase) throws SQLException, IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which position do you want to update? Enter user_id");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Enter new Author");
        String author = reader.readLine();
        dataBase.get(id).setAuthor(author);
        //    sql = "UPDATE my_book_shelf set user_id = " + newId + " where user_id=" + id + ";";
        String sql = "UPDATE my_book_shelf set author = ? where user_id=" + id + ";";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setString(1, author);
        pstmt.execute();
        c.commit();
    }

    public static void updateTitleById(Connection c, HashMapDatabase dataBase) throws SQLException, IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which position do you want to update? Enter user_id");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Enter new title:");
        String title = reader.readLine();
        dataBase.get(id).setTitle(title);
        //    sql = "UPDATE my_book_shelf set user_id = " + newId + " where user_id=" + id + ";";
        String sql = "UPDATE my_book_shelf set title = ? where user_id=" + id + ";";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setString(1, title);
        pstmt.execute();
        c.commit();
    }
}