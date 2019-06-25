package com.stackroute.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookedUnit {

    @Id
    private String uuId;
    //private int id;
    private String emailId;
    private String name;
    private String location;
    private float sqft;
    private Date start_date;
    private Date end_date;

}