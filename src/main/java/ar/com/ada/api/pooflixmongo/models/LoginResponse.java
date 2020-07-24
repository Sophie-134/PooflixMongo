package ar.com.ada.api.pooflixmongo.models;

import org.bson.types.ObjectId;

public class LoginResponse {
    public ObjectId _id;
    public String username;
    public String token;
    public String email;
}