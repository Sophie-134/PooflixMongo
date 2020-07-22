package ar.com.ada.api.pooflixmongo.controllers;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.ada.api.pooflixmongo.models.GenericResponse;

import ar.com.ada.api.pooflixmongo.entities.*;
import ar.com.ada.api.pooflixmongo.services.*;

@RestController
@RequestMapping("/api/series")
public class SerieController {

    @Autowired
    SerieService serieService;

    @PostMapping("/")
    public ResponseEntity<GenericResponse> crearSerie(@RequestBody Serie serieInfo) {

        serieService.grabar(serieInfo);
        GenericResponse response = new GenericResponse();
        response.isOK = true;
        response.message = "Serie creada con exito!";
        response.id = serieInfo.get_id(); //.toHexString(); ->para q lo transforme en hexadecimal, pero ya esta en el get_id de Contenido

        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<List<Serie>> listarSeries() {

        return ResponseEntity.ok(serieService.listarSeries());
    }
//este GET en base a un Id de tipo String transforma a un ObjectId
    @GetMapping("/{id}")
    public ResponseEntity<Serie> GetSerie(@PathVariable String id) {

        ObjectId obId = new ObjectId(id);

        Serie s = serieService.buscarPorId(obId);
        if (s == null)
            return ResponseEntity.notFound().build();
            
        return ResponseEntity.ok(s);
        // obtener la serie
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){

        ObjectId obId = new ObjectId(id);
        Serie s = serieService.buscarPorId(obId);
        if (s == null){
        return ResponseEntity.notFound().build();
        }
        serieService.deleteById(obId);

        GenericResponse resp = new GenericResponse();
        resp.isOK = true;
        resp.id = s.get_id();
        resp.message = "Serie "+ s.getNombre() + " eliminada, felicidades";
        return ResponseEntity.ok(resp);
    }
}