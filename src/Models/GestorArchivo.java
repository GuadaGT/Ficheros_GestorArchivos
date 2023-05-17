package Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class GestorArchivo
{
    public void crearArchivo(String nombreArchivo)
    {
        //Creamos el archivo con la función "createNewFile"
        File file = new File(nombreArchivo + ".txt");

        try
        {
            if (file.createNewFile())
            {
                System.out.println("El fichero se ha creado correctamente.");
            }
            else
            {
                System.out.println("Ha ocurrido un error inesperado");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void escribirArchivo(String nombreArchivo, String[] contenido)
    {
        try
        {
            File file = new File(nombreArchivo + ".txt");
            //Con esto sobreescribe el archivo y por eso tenemos que añadir si o si el append "true" para qu vaya
            //anexando la información a lo que ya hay esrito.
            FileWriter fw = new FileWriter(file,true);

            for (String linea : contenido)
            {
                fw.write(linea);
            }
            fw.close();

            //Mensaje de información acerca de la información añadida al fichero y el nombre del fichero en concreto donde
            //hemos incluido el contenido.
            System.out.println("Se ha escrito: " + contenido + " en el fichero: " + nombreArchivo);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public String leerArchivo(String nombreArchivo)
    {
        try
        {
            //Concatenación de la cadena.
            String devuelveCadena = "";
            //Esto solo lee caracteres y como nosotros queremos leer la línea entera incluimos el BufferedReader.
            File file = new File (nombreArchivo + ".txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            //Tenemos que ir guardando cada linea que tenga el archivo por tanto habrá que crear un while junto con el valor de
            // de la linea con un readLine() en el bucle while.
            //Si la linea no está en nulo seguimos leyendo el archivo con el parámetro readLine()
            String linea;
            while ((linea = br.readLine()) != null)
            {
                //Vamos añadiendo la linea.
                devuelveCadena += " " + linea;
            }

            //Cerramos tanto el filereader como el bufferedreader para que se realicen las funciones
            //de forma correcta.
            fr.close();
            br.close();

            return devuelveCadena;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  "";
    }
}
