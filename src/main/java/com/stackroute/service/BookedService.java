package com.stackroute.service;

import com.stackroute.exceptions.BookedServiceAlreadyExistsException;
import com.stackroute.exceptions.StorageUnitNotFoundException;
import com.stackroute.model.BookedUnit;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface BookedService
{
    public List<BookedUnit> getAllBookedUnit();
    public BookedUnit saveBookedUnit(BookedUnit bookedUnit) throws BookedServiceAlreadyExistsException;
    public boolean deleteBookedUnit(String uuId) throws StorageUnitNotFoundException;
    public BookedUnit updateBookedUnit(BookedUnit bookedUnit) throws StorageUnitNotFoundException;
}
