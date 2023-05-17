import Models.GestorArchivo;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        GestorArchivo gestor = new GestorArchivo();
        File resources = new File("src/resources");
        boolean mkdirR = resources.mkdirs();

        String[] contenidoArchivo1 = {"Línea 1", "Línea 2", "Línea 3"};
        String[] contenidoArchivo2 = {"Texto de ejemplo", "Otra línea"};

        gestor.crearArchivo("archivo1.txt");
        gestor.escribirArchivo("archivo1.txt", contenidoArchivo1);

        gestor.crearArchivo("archivo2.txt");
        gestor.escribirArchivo("archivo2.txt", contenidoArchivo2);

        String contenidoLeido1 = gestor.leerArchivo("archivo1.txt");
        System.out.println("Contenido del archivo1.txt:");
        System.out.println(contenidoLeido1);

        String contenidoLeido2 = gestor.leerArchivo("archivo2.txt");
        System.out.println("Contenido del archivo2.txt:");
        System.out.println(contenidoLeido2);
    }
}
