package ar.com.ada.api.pooflixmongo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.pooflixmongo.entities.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository <Usuario, Integer> {
    
    public Usuario findByUsername(String userName);
    public Usuario findByEmail(String email);
}