package ar.com.ada.api.pooflixmongo.models;

import org.bson.types.ObjectId;

public class RegistrationResponse {
    
    public boolean isOk = false;
    public String message = "";
    public ObjectId userId ;
}