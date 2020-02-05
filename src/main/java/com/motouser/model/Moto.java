package com.motouser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Moto {

    @Id
    private int motoId;
    public String brand;
    public int year;
    public int engineVolume;
    public String idDriver;

}

// создать гет пут пост дел для драйвера и для мото