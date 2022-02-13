package DAO.impl;

import DAO.DaoPlane;
import configurationDB.DataBase;
import entity.Cargo_Plane;
import entity.Passangers_Plane;
import entity.Plane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class DaoPlaneImpl implements DaoPlane {
    private final String COMAND_FOR_GET_ALL = "SELECT * FROM AVIAPARK";

    @Override
    public List<Passangers_Plane> getAll_passangers() {
        List<Passangers_Plane> listPass_Plane = new ArrayList<>();
        try (Connection connection = DataBase.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(COMAND_FOR_GET_ALL)) {
                      while (resultSet.next()) {
                if (resultSet.getString("type").toUpperCase(Locale.ROOT).
                        equals("passenger".toUpperCase(Locale.ROOT))) {
                    int id = resultSet.getInt("id");
                    String type = resultSet.getString("type");
                    String producer = resultSet.getString("producer");
                    String model = resultSet.getString("model");
                    double fuel_consumption_per_1000_km = resultSet.getDouble("fuel_consumption_per_1000_km");
                    double tank_volume = resultSet.getDouble("tank_volume");
                    int passenger_capacity = resultSet.getInt("passenger_capacity");
                    Passangers_Plane passangers_plane = new Passangers_Plane(id, type, producer, model,
                    fuel_consumption_per_1000_km, tank_volume, passenger_capacity);
                    listPass_Plane.add(passangers_plane);
                }
            }
            return listPass_Plane;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

        @Override
    public List<Cargo_Plane> getAll_cargo() {
        List <Cargo_Plane> listCargo_Pnale = new ArrayList<>();
        try (Connection connection = DataBase.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(COMAND_FOR_GET_ALL)) {
            while (resultSet.next()) {
                if (resultSet.getString("type").toUpperCase(Locale.ROOT).
                        equals("cargo".toUpperCase(Locale.ROOT))) {
                    int id = resultSet.getInt("id");
                    String type = resultSet.getString("type");
                    String producer = resultSet.getString("producer");
                    String model = resultSet.getString("model");
                    double fuel_consumption_per_1000_km = resultSet.getDouble("fuel_consumption_per_1000_km");
                    double tank_volume = resultSet.getDouble("tank_volume");
                    int tonnage = resultSet.getInt("tonnage");
                    Cargo_Plane cargo_plane = new Cargo_Plane(id, type, producer, model,
                            fuel_consumption_per_1000_km, tank_volume, tonnage);
                    listCargo_Pnale.add(cargo_plane);
                }
            }
            return listCargo_Pnale;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
