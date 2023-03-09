package pl.sda.orange2.dao;

import pl.sda.orange2.entity.CarRec;

import javax.xml.crypto.Data;
import java.util.List;

//Data Access Object
//Warstwa dostępu do bazy danych
public class CarDao implements DataAccess<CarDao, Long> {


    @Override
    public void save(CarDao car) {

    }

    @Override
    public List<CarDao> findAll() {
        return null;
    }

    @Override
    public CarDao findById(Long id) {
        return null;
    }

    @Override
    public void deletyById(Long id) {

    }
}
