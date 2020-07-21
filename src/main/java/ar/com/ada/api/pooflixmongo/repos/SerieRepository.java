package ar.com.ada.api.pooflixmongo.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.pooflixmongo.entities.Serie;


@Repository
public interface SerieRepository extends MongoRepository<Serie,ObjectId>{

    Serie findBy_id(ObjectId id);

    Serie findByNombre(String nombre);
}