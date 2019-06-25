package com.stackroute.controller;

import com.stackroute.exceptions.BookedServiceAlreadyExistsException;
import com.stackroute.exceptions.StorageUnitNotFoundException;
import com.stackroute.model.BookedUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class BookController
{
    com.stackroute.service.BookedService bookedServiceService;
    @Autowired
    public BookController(com.stackroute.service.BookedService bookedServiceService) {
        this.bookedServiceService = bookedServiceService;
    }

    @PostMapping("/bookedunit")
    public ResponseEntity<?> addBookedUnit(@RequestBody BookedUnit bookedUnit)  throws BookedServiceAlreadyExistsException {
        ResponseEntity responseEntity;
        try{
            bookedServiceService.saveBookedUnit (bookedUnit);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);

        }catch (BookedServiceAlreadyExistsException ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);

        }
        return responseEntity;
    }

    @GetMapping("/allbookedunit")
    public ResponseEntity<?> getAllBookedUnit(){
        return  new ResponseEntity<List<BookedUnit>>(bookedServiceService.getAllBookedUnit(),HttpStatus.OK);
    }


    @PatchMapping("/listbookedunit")
    public ResponseEntity<?> updateAlbum(@RequestBody BookedUnit bookedUnit) throws StorageUnitNotFoundException {
        ResponseEntity responseEntity;
        try{
            bookedServiceService.updateBookedUnit(bookedUnit);
            responseEntity=new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);
        }
        catch(StorageUnitNotFoundException exception){
            responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @DeleteMapping("/bookedunitno/{uuid}")
    public ResponseEntity<?> deleteBookedUnit(@PathVariable("uuid") String id) throws StorageUnitNotFoundException
    {
        ResponseEntity responseEntity;
        try {
            bookedServiceService.deleteBookedUnit(id);
            responseEntity = new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
        }
        catch(StorageUnitNotFoundException exception){

            responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
