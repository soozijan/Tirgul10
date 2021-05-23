package com.example.demo;

import java.sql.*;
import java.util.ArrayList;

public class SpecialDayDAO {
    private String m_conn;

    public SpecialDayDAO(String m_conn) {
        this.m_conn = m_conn;
    }

    public void insertSpecialDay(SpecialDay specialDay) {
        try (Connection conn = DriverManager.getConnection(m_conn)) {
            if (conn != null) {

                String sql = String.format("INSERT INTO specialDay (name, day, month) " +
                        "VALUES ( '%s', %d, %d )", specialDay.getName(), specialDay.getDay(), specialDay.getMonth());
                Statement stmt = conn.createStatement();

                stmt.executeUpdate(sql);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateSpecialDay(SpecialDay specialDay, int id) {
        try (Connection conn = DriverManager.getConnection(m_conn)) {
            if (conn != null) {
                String sql = String.format(
                        "UPDATE specialDay set name = '%s', day = %d, month = %d " +
                                " WHERE id = %d"
                        , specialDay.getName(), specialDay.getDay(), specialDay.getMonth(), id);
                Statement stmt = conn.createStatement();

                stmt.executeUpdate(sql);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteSpecialDay(int id) {
        try (Connection conn = DriverManager.getConnection(m_conn)) {
            if (conn != null) {
                String sql = String.format("DELETE from specialDay where id = " + id);
                Statement stmt = conn.createStatement();

                stmt.executeUpdate(sql);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public ArrayList<SpecialDay> getAllSpecialDay(){

        ArrayList<SpecialDay> specialDay = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)) {

            if (conn != null) {

                String sql = "SELECT * FROM SpecialDay";

                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    SpecialDay e = new SpecialDay(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("day"),
                            rs.getInt("month")
                            );
                    specialDay.add(e);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return specialDay;
    }

    public SpecialDay getSpecialDayById(int id){
        // try to connect to db
        try (Connection conn = DriverManager.getConnection(m_conn)) {
            // check if connection succeed
            if (conn != null) {

                // prepare query string
                String sql = String.format("Select * from SpecialDay where id = %d", id );

                // prepare statement
                Statement stmt = conn.createStatement();

                // fire query
                ResultSet rs = stmt.executeQuery(sql);

                // read results
                while (rs.next()) {
                    SpecialDay specialDay = new SpecialDay(
                            rs.getInt("Id"),
                            rs.getString("Name"),
                            rs.getInt("day"),
                            rs.getInt("month")
                            );
                    return specialDay;
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }
}
