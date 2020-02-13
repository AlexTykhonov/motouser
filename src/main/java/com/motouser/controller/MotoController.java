package com.motouser.controller;

import com.motouser.model.Moto;
import com.motouser.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.util.BsonUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.SQLOutput;

@RestController
@CrossOrigin
@RequestMapping ("/api/moto")
public class MotoController {

@Autowired
MotoRepository motoRepository;

@GetMapping
    public Flux<Moto> getAllMoto () {
    return motoRepository.findAll();
}

@GetMapping ("/{id}")
public  Mono <Moto> getTheMoto(@PathVariable String id) {
    System.out.println(" *********************** "+id);
    motoRepository.findById(id).subscribe(x-> System.out.println(x));
return motoRepository.findById(id);
}

@PostMapping
    public Mono<Moto> postMoto (@RequestBody Moto moto) {
    return motoRepository.save(moto);
}


@PutMapping("/{id}")
    public Mono<Moto> putMoto (@PathVariable String id, @RequestBody Moto moto) {
        return motoRepository.findById(id).flatMap(oldMoto -> {
            oldMoto.setBrand(moto.getBrand());
            oldMoto.setEngineVolume(moto.getEngineVolume());
            oldMoto.setYear(moto.getYear());
            return motoRepository.save(oldMoto);
        });
    }

    @DeleteMapping("/{motoId}")
    public Mono<String> deleteMoto(@PathVariable String motoId) {
        return motoRepository.findById(motoId).flatMap(moto -> motoRepository.delete(moto)).then(Mono.just("Deleted"));
    }

    @DeleteMapping
    public void delAll () {
        motoRepository.deleteAll();
        System.out.println("All motos were deleted!");
    }
}
