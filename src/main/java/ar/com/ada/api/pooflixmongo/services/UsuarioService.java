package ar.com.ada.api.pooflixmongo.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pooflixmongo.entities.Usuario;
import ar.com.ada.api.pooflixmongo.repos.UsuarioRepository;
import ar.com.ada.api.pooflixmongo.security.Crypto;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repo;
    
    public Usuario crearUsuario(String nombre, String pais, String tipoDocumento, int documento, Date fechaNacimiento,
      String email, String password) {

        Usuario usuario = new Usuario();
    usuario.setNombre(nombre);
    usuario.setPais(pais);
    usuario.setTipoDocumento(tipoDocumento);
    usuario.setDocumento(documento);
    usuario.setFechaNacimiento(fechaNacimiento);

    usuario.setUsername(email);
    usuario.setEmail(email);
    usuario.setPassword(Crypto.encrypt(password, email));

    repo.save(usuario);
    return usuario;
      }

      public Usuario buscarPorUsername(String username) {
        return repo.findByUsername(username);
      }
    
      public void login(String username, String password) {
        /**
         * Metodo IniciarSesion recibe usuario y contraseña validar usuario y contraseña
         */
    
        Usuario u = buscarPorUsername(username);
    
        if (u == null || !u.getPassword().equals(Crypto.encrypt(password, u.getUsername()))) {
    
          throw new BadCredentialsException("Usuario o contraseña invalida");
        }
      }
      
}