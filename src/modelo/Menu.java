package modelo;

import javax.crypto.spec.PSource;
import java.util.Scanner;

public class Menu {

    public void menu(){

    int limite = 10;
    int opcion;
    int rtaLimite; /*Idea de Pau*/
    String nuevoNombre;  /*Idea de Ana*/
        String nuevoTelefono;

    /*Instanciar*/
    Agenda agenda = new Agenda();

    Scanner scanner = new Scanner(System.in);


    //Menú de Opciones para nuestra la agenda Telefónica :)

        System.out.println("------- \n 😁😁 ¡Bienvenido a tu agenda personalizada!  😁😁 \n ---" +
                "----¿Quieres añadir más de 10 contactos en tu agenda? 📒 Coloca 1 para SI, o 2 para NO  ");

        rtaLimite = scanner.nextInt(); /*Idea de Camilo y Ana*/


        //Definimos tamaño con usando un Switch --> Idea de Nachito!!! 🥳
        //Lo elegimos porque nos permite elegir entre diferentes escenarios!!!!

        switch (rtaLimite){
            case 1:
                System.out.println("Ingresa el número de contactos que quieres para tu agenda");
                limite = scanner.nextInt();
                break;
            case 2:
                System.out.println("El tamaño por defecto sera: 10 ");
                break;
            default:
                System.out.println("🚫 ¡Opción no valida! 🚫");
        }


        //Seteando limite de agenda
        agenda.setLimite(limite);


        //Menú de opciones de la agenda --> Idea de Pau Osorio

        do {
            System.out.println("-----🫵🏼🫵🏼🫵🏼----");
            System.out.println("Menú de opciones: \n " +
                    "1. Añade un contacto. \n" +
                    "2. Verificar si existe un contacto. \n" +
                    "3. Listar contactos. \n" +
                    "4. Buscar contacto.\n" +
                    "5. Eliminar Contacto.\n" +
                    "6. Modificar Telefono. \n" +
                    "7. Verificar agenda llena.\n" +
                    "8. Verificar espacios libres en agenda.\n" +
                    "9. Salir.\n" +
                    "\nIngresa la opción que deseas: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    do {
                        System.out.println("Ingrese el nombre del contacto: ");
                        nuevoNombre = scanner.nextLine().trim().toLowerCase();

                        if (nuevoNombre.isEmpty()) {
                            System.out.println("El nombre no puede estar vacío ni contener solo espacios.");
                        }
                    } while (nuevoNombre.isEmpty());

                    do {
                        System.out.println("Ingresa el teléfono del nuevo contacto: ");
                        nuevoTelefono = scanner.nextLine().trim();

                        if (nuevoTelefono.isEmpty()) {
                            System.out.println("El teléfono no puede estar vacío ni contener solo espacios.");
                        }
                    } while (nuevoTelefono.isEmpty());

                    Contactos nuevoContacto = new Contactos(nuevoNombre, nuevoTelefono);
                    agenda.anadirContacto(nuevoContacto);

                    break;
                case 2:
                    System.out.println("Escribe el nombre del contacto que deseas verificar: ");
                    nuevoNombre = scanner.nextLine().toLowerCase();
                    agenda.existeContacto(nuevoNombre);
                    break;
                case 3:
                    agenda.listarContactos();
                    break;
                case 4:
                    System.out.println("Escribe el nombre del contacto que deseas buscar: ");
                    nuevoNombre = scanner.nextLine().toLowerCase();
                    agenda.buscaContacto(nuevoNombre);
                    break;
                case 5:
                    System.out.println("Ingresa el nombre del contacto que quieres eliminar: ");
                    nuevoNombre = scanner.nextLine();
                    agenda.eliminarContacto(nuevoNombre.toLowerCase());
                    break;
                case 6:
                    System.out.println("Escribe el nombre del contacto del cual quieres modificar el numero: ");
                    nuevoNombre =scanner.next();
                    agenda.existeContacto(nuevoNombre);
                    System.out.println("Ingresa el nuevo numero de telefono");
                    nuevoTelefono =scanner.next();
                    agenda.modificarTelefono(nuevoNombre,nuevoTelefono);
                    break;

                case 7:
                    agenda.agendaLlena();
                    break;
                case 8:
                    agenda.espaciosLibres();
                    break;
                case 9:
                    System.out.println("Cerrando tu agenda...");
                    break;
                default:
                    System.out.println("Por favor ingrese una opción válida");
            }

        } while (opcion != 9); //Se sale









    }

}
