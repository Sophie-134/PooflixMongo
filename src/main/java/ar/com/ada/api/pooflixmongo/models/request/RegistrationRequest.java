package ar.com.ada.api.pooflixmongo.models.request;

import java.util.Date;

/**
 * RegistrationRequest
 */
public class RegistrationRequest {

    public String fullName; //Nombre persona
    public String country; //pais del usuario
    public String identificationType; //Tipo Documento
    public int identification; //nro documento
    public Date birthDate; //fechaNacimiento
    public String email; //email
    public String password; //contraseña elegida por el usuario.
    
}