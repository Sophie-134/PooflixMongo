package ar.com.ada.api.pooflixmongo.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pooflixmongo.entities.Serie;
import ar.com.ada.api.pooflixmongo.repos.SerieRepository;

@Service
public class SerieService {

    @Autowired
    SerieRepository sRepository;

    public void grabar(Serie serie) {
        sRepository.save(serie);
    }

    public List<Serie> listarSeries() {
        return sRepository.findAll();
    }

    public Serie buscarPorId(ObjectId id) {
        return sRepository.findBy_id(id);

    }

    public void deleteById(ObjectId id) {
        sRepository.deleteById(id);
    }
}