package pl.sda.orange2.dao;

import pl.sda.orange2.entity.CarRec;

import java.util.List;

//E jak Entity
public interface DataAccess<E, ID> {

    void save(E car);

    List<E> findAll();

    E findById(ID id);

    void deletyById(ID id);

}
