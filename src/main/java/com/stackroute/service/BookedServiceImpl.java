package com.stackroute.service;

import com.stackroute.exceptions.BookedServiceAlreadyExistsException;
import com.stackroute.exceptions.StorageUnitNotFoundException;

import com.stackroute.model.BookedUnit;
import com.stackroute.repository.BookedServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookedServiceImpl implements BookedService
{
    @Autowired
    BookedServiceRepository bookedRepository;
    //BookedUnit bookedUnit;

    @Autowired
    public BookedServiceImpl(BookedServiceRepository bookedRepository) {
        this.bookedRepository = bookedRepository;
       // this.bookedUnit = bookedUnit;
    }





    @Override
    public List<BookedUnit> getAllBookedUnit() {

        //bookedUnit= new BookedUnit();
        return bookedRepository .findAll();



    }


    @Override
    public BookedUnit saveBookedUnit(BookedUnit bookedUnit) throws BookedServiceAlreadyExistsException {
//      if(BookedUnit.existsByUuid(bookedUnit.getUuid())) {
//            throw new BookedServiceAlreadyExistsException("BookedUnit already exists with id:[" + bookedUnit.getUuid() + "]");
//        }
       // BookedUnit savedBookedUnit =
                bookedRepository.save(bookedUnit);
        return bookedUnit;



    }


    @Override
    public boolean deleteBookedUnit(String id) throws StorageUnitNotFoundException {
        boolean status = false;
        if(bookedRepository.existsById(id)){
            bookedRepository.deleteById(id);
            status=true;
            return status;
    } else {
            throw new StorageUnitNotFoundException("userId not exists");
        }

    }

    @Override
    public BookedUnit updateBookedUnit(BookedUnit bookedUnit) throws StorageUnitNotFoundException {
        if (bookedRepository.existsById(bookedUnit.getUuId())) {
            BookedUnit savedBookedUnit = bookedRepository.save(bookedUnit);
            return savedBookedUnit;
        } else {
            throw new StorageUnitNotFoundException("BookedUnit not found");

        }

    }
}
