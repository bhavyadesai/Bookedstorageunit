package com.stackroute.repository;

import com.stackroute.model.BookedUnit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// TODO
// Make this as a class
// Generate UUID before adding a warehouse
// https://craftingjava.com/custom-document-id-spring-data-mongodb/
@Repository
public interface BookedServiceRepository extends MongoRepository<BookedUnit, String>
{
}
