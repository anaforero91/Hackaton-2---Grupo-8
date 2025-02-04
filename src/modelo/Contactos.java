package modelo;

public class Contactos {

    // Definimos Atríbutos

    private String nombre;
    private String telefono;

    //Constructor Vacío

    public Contactos(){
    }

    public Contactos(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



}
