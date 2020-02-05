package com.motouser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Driver {

    @Id
    private String id;
    public String name;
    public int age;
    private List<Moto> motoList = new ArrayList<>();

    public List <Moto> addMoto (Moto moto) {
       this.motoList.add(moto);
       return this.motoList;
    }
}
