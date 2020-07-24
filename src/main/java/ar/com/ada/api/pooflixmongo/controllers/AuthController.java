package ar.com.ada.api.pooflixmongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.pooflixmongo.entities.Usuario;
import ar.com.ada.api.pooflixmongo.models.LoginResponse;
import ar.com.ada.api.pooflixmongo.models.RegistrationResponse;
import ar.com.ada.api.pooflixmongo.models.request.LoginRequest;
import ar.com.ada.api.pooflixmongo.models.request.RegistrationRequest;
import ar.com.ada.api.pooflixmongo.security.jwt.JWTTokenUtil;
import ar.com.ada.api.pooflixmongo.services.JWTUserDetailsService;
import ar.com.ada.api.pooflixmongo.services.UsuarioService;




/**
 * AuthController
 */
@RestController
public class AuthController {

    @Autowired
    UsuarioService usuarioService;

    /*
     * @Autowired private AuthenticationManager authenticationManager;
     */
    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private JWTUserDetailsService userDetailsService;
    //Auth : authentication ->
    @PostMapping("api/auth/register")
    public ResponseEntity<RegistrationResponse> postRegisterUser(@RequestBody RegistrationRequest req) {
        RegistrationResponse r = new RegistrationResponse();
        // aca creamos la persona y el usuario a traves del service.
        //Insertar codigo aqui
        Usuario usuario = usuarioService.crearUsuario(req.fullName, req.country, req.identificationType, req.identification, req.birthDate, req.email, req.password);
       //tmb se puede hacer Usuario usuario = usuarioService.crearUsuario(req.fullName, req.cou, blabla);
        r.isOk = true;
        r.message = "Te registraste con exitoooo!!!!!!!";
        r.userId = usuario.get_id(); // <-- AQUI ponemos el numerito de id para darle a front!
        return ResponseEntity.ok(r);

    }

    @PostMapping("api/auth/login") // probando nuestro login
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
            throws Exception {

        usuarioService.login(authenticationRequest.username, authenticationRequest.password);

        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.username);

        String token = jwtTokenUtil.generateToken(userDetails);

        //return ResponseEntity.ok(new JwtResponse(token));

        //Cambio para que devuelva el full perfil
        Usuario u = usuarioService.buscarPorUsername(authenticationRequest.username);

        LoginResponse r = new LoginResponse();
        r._id = u.get_id();
        r.username = authenticationRequest.username;
        r.email = u.getEmail();
        r.token = token;

        return ResponseEntity.ok(r);
        

    }

}