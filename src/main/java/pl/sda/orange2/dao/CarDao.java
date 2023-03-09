package pl.sda.orange2.dao;

import pl.sda.orange2.entity.CarRec;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Data Access Object
//Warstwa dostępu do bazy danych
public class CarDao implements DataAccess<CarRec, Long> {

    private final Connection dbConnection;

    public CarDao(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void save(CarRec car) {

        String saveQuery;
        if (car.id() != null) {
            //update

        } else {
            //save
            saveQuery = """
                    INSERT INTO CARS
                    (COLOR, BRAND, MODEL)
                    VALUES (?,?,?)
                    """;

            try {
                PreparedStatement queryStatement = dbConnection.prepareStatement(saveQuery);
                queryStatement.setString(1, car.color());
                queryStatement.setString(2, car.brand());
                queryStatement.setString(3, car.model());
                int result = queryStatement.executeUpdate();


            } catch (SQLException e) {
                System.out.println("Unexpected SQL exception occurred");
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<CarRec> findAll() {
        var result = new ArrayList<CarRec>();

        //TODO: validate query
        String allCarsQuery = """
                SELECT ID, COLOR, BRAND, MODEL
                FROM CARS
                """;

        try {

            Statement queryStatement = dbConnection.createStatement();
            ResultSet queryResult = queryStatement.executeQuery(allCarsQuery);

            while (queryResult.next()) {
                Long id = queryResult.getLong(1);
                String color = queryResult.getString(2);
                String brand = queryResult.getString(3);
                String model = queryResult.getString(4);

                CarRec carFromDB = new CarRec(id, color, brand, model);
                result.add(carFromDB);
            }
        } catch (SQLException e) {
            System.out.println("Unexpected SQL exception occurred");
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public CarRec findById(Long id) {

        //TODO: validate query
        String carByIDQuery = """
                SELECT ID, COLOR, BRAND, MODEL
                FROM CARS
                WHERE ID = ?
                """;
        CarRec result = null;

        try {


            PreparedStatement queryStatement = dbConnection.prepareStatement(carByIDQuery);
            queryStatement.setLong(1, id);
            ResultSet queryResult = queryStatement.executeQuery();

            //ten if sprawdza, czy był jakikolwiek rezultat
            if (queryResult.next()) {
                result = new CarRec(
                        queryResult.getLong("ID"),
                        queryResult.getString("COLOR"),
                        queryResult.getString("BRAND"),
                        queryResult.getString("MODEL"));

            }


        } catch (SQLException e) {
            System.out.println("Unexpected SQL exception occurred");
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void deletyById(Long id) {
//TODO: validate query
        String deleteCatByID = """
                DELETE
                FROM CARS
                WHERE ID = ?
                """;

        try {
            PreparedStatement queryStatement = dbConnection.prepareStatement(deleteCatByID);
            queryStatement.setLong(1, id);
            int numberOfTouchedRecords = queryStatement.executeUpdate();
            System.out.println(numberOfTouchedRecords);

        } catch (SQLException e) {
            System.out.println("Unexpected SQL exception occurred");
            e.printStackTrace();
        }
    }
}
