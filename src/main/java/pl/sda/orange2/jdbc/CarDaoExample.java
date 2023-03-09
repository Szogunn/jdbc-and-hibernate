package pl.sda.orange2.jdbc;

import pl.sda.orange2.dao.CarDao;
import pl.sda.orange2.entity.CarRec;
import pl.sda.orange2.jdbc.config.H2Config;

import java.sql.DriverManager;
import java.sql.SQLException;

public class CarDaoExample {

    public static void main(String[] args) {

        System.out.println("Car dao example");
        System.out.println("Reading all cars from db");

        try {
            var h2Connection = DriverManager.getConnection(H2Config.DB_URL,
                    H2Config.USER,
                    H2Config.PASSWORD);

            CarDao carDao = new CarDao(h2Connection);
            var allCarsFromDB = carDao.findAll();
            System.out.println(allCarsFromDB);

            System.out.println("Find by ID");
            CarRec existingCar = carDao.findById(1L);
            System.out.println("Existing car: " + existingCar);

            System.out.println("Find By ID by ID which is not in db");
            CarRec notExistingCar = carDao.findById(5L);
            System.out.println("Existing car: " + notExistingCar);


            System.out.println("Delete by ID");
            carDao.deletyById(3L);

            System.out.println(carDao.findAll());

            System.out.println("Save Car");
            carDao.save(new CarRec(null, "pink" , "Fiat" , "Maluch"));
            System.out.println(carDao.findAll());

            System.out.println("update CAR");
            carDao.save(new CarRec(1L,"LOl" , "LOlx2" , "UpdatedCAr"));
            System.out.println(carDao.findAll());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
