package modelo;

import java.util.*;


/*Constructores*/
    public class Agenda {
    private List<Contactos> contactosList ;
    private Map <String, String> mapearContacto;
    private int limite;


    public Agenda (){
        this.contactosList = new ArrayList<>();
        this.mapearContacto = new HashMap<>();
    }


    //getter y Setter

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    /*Métodos*/

    //Añadir Contactos

    public void anadirContacto (Contactos contactos){
        //Si el tamaño de la lista es menor que el limite y el nombre es igual que null
        if (contactosList.size() < getLimite() && mapearContacto.get(contactos.getNombre()) == null){
            contactosList.add(contactos);
            mapearContacto.put(contactos.getNombre(), contactos.getTelefono());
            System.out.println("  ---  🥳¡Contacto añadido exitosamente!🥳  ---  ");

        }else {
            System.out.println("Lo lamentamos no se puede añadir un nuevo contacto 😥");
            if (contactosList.size()>= getLimite()){
                agendaLlena();
            } else if (mapearContacto.get(contactos.getNombre())!=null) {
                existeContacto(contactos.getNombre());
            }
        }
    }

    //Verificar si el contacto existe!!!

    public boolean existeContacto(String nombre){
        if (mapearContacto.get(nombre)==null){
            System.out.println("Ese contacto no Existe! 😮😧");
            return false;
        }else {
            System.out.println(" ✅ ¡¡El contacto Existe!!  ✅😁 ");
            return true;
        }
    }

    //Agenda Llena
    public void agendaLlena(){
        if (contactosList.size() == getLimite()){
            System.out.println(" 📒🚫 ¡La agenda se encuentra LLena! 📒🚫");
        }else {
            System.out.println("Aun hay espacios disponibles..👌");
        }
    }

    //Mostrar contactos
    public void listarContactos (){
        int i=1;

        System.out.println("-----------------");
        System.out.println("----Tu Agenda----");
        System.out.println("-----------------");
        System.out.println();

        /*ORGANIZAR ALFABETICAMENTE*/
        contactosList.sort(Comparator.comparing(Contactos::getNombre));

        for (Contactos contacto : contactosList){
            System.out.printf("Contacto %d: nombre: %s, teléfono: %s\n", i, contacto.getNombre(), contacto.getTelefono());
            i++;
        }
        System.out.println("--------------------------------------------------");
    }

    //Buscar contacto
    public void buscaContacto(String nombre){
        if (mapearContacto.get(nombre) == null){
            System.out.println("El contacto no existe");
        } else{
            for (Contactos contacto: contactosList){
                if(contacto.getNombre().equals(nombre)) {
                    System.out.printf("El teléfono de %s es %s\n", contacto.getNombre(), contacto.getTelefono());
                    break;
                }
            }
        }

    }

    //Eliminar
    public void eliminarContacto(String nombre){
        if (mapearContacto.get(nombre) == null){
            System.out.println("El contacto no existe");
        } else{
            for (Contactos contacto: contactosList){
                if(contacto.getNombre().equals(nombre)) {
                    contactosList.remove(contacto);
                    System.out.println("Contacto eliminado exitosamente.");
                    break;
                }
            }
        }

    }

    public void modificarTelefono(String nombre, String nuevoTelefono) {
        if (mapearContacto.get(nombre) == null) {
            System.out.println("El contacto no existe");
        } else {
            for (Contactos contacto : contactosList) {
                if (contacto.getNombre().equals(nombre)) {
                    mapearContacto.containsKey(mapearContacto.get(nombre));
                    contacto.setTelefono(nuevoTelefono);
                    System.out.println("el nuevo numero de " + nombre + " es: " + nuevoTelefono);
                    break;
                }


            }
        }
    }

    public void espaciosLibres(){
        int espacios = getLimite()-contactosList.size();
        System.out.println("Quedan "+espacios+" espacios disponibles.");
    }




}
