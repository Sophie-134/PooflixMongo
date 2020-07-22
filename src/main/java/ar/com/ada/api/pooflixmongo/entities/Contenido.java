package ar.com.ada.api.pooflixmongo.entities;

import org.bson.types.ObjectId;

public class Contenido {

    //Id del documento dentro de la coleccion
    private ObjectId _id;
    
    private String nombre;

    private String clasificacion;

    private double calificacion;

    private String genero;

    private int anio;

    private String descripcion;

    public void reproducir () {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

	   //HACK para que el ObjectId se dibuje en JSON como string
    //solo tocar el getter
    public String get_id(){
        return _id.toHexString();
    }

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
}
