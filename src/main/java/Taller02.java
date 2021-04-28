import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Taller02 {

    public static void main(String[] args) throws IOException {

            Scanner teclado = new Scanner(System.in);

            System.out.println("Ingrese una ruta");

            String ruta = teclado.nextLine();
            Programa(ruta);
    }

    //Metodo que retorna la cantidad de palíndromos y lineas

    public static void Programa(String ruta) throws IOException {

        if(validarArchivo(ruta)) {
        int Palindromos = mostrarPalindromo(ruta);
        int lineas = largoArchivo(ruta);

        System.out.println("La cantidad de palíndromos es: " + Palindromos);
        System.out.println("La cantidad de líneas del archivo es: " + lineas);
    }else{
            System.out.println("Archivo no encontrado");
        }
    }


    //Metodo que valida un archivo ingresado

    public static boolean validarArchivo(String ruta) {
        File file = new File(ruta);
        return file.isFile();
    }

    //Metodo que lee un archivo ingresado

    public static ArrayList<String> leerArchivo(String ruta) throws IOException {


            ArrayList<String> lineas = new ArrayList<>();
            String cadena;
            FileReader archivo = new FileReader(ruta);
            BufferedReader b = new BufferedReader(archivo);
            while ((cadena = b.readLine()) != null) {
                cadena = cadena.replace("\"\"",""); //cadenas.txt ya traen "", esto genera problemas después
                lineas.add(cadena);
            }
            return lineas;
    }

    //Metodo que devuelve el largo del archivo

    public static int largoArchivo(String ruta) throws IOException {

        return leerArchivo(ruta).size();
    }

    //Metodo que devuelve la línea del archivo

    public static String retornarLinea(String ruta, int i) throws IOException {

        int largo = largoArchivo(ruta);
        ArrayList<String> archivo = new ArrayList<>(leerArchivo(ruta));

        return archivo.get(i);
    }

    //Metodo que muestra en pantalla si la línea es o no palíndromo

    public static int mostrarPalindromo(String ruta) throws IOException {

        int totalPalindromos = 0;

            int largo = largoArchivo(ruta);

            for (int i = 0; i < largo; i++) {

                if (verificarPalindromo(retornarLinea(ruta, i))) {

                    System.out.println("La linea " + i + " es palíndromo");
                    totalPalindromos++;
                } else {
                    System.out.println("La linea " + i + " no es palíndromo");
                }
            }
        return totalPalindromos;
    }

    //Metodo que formatea el texto

    public static String formatearTexto(String palabra) {

        palabra = palabra.toLowerCase();
        String spechar = "áéíóú";
        String chara = "aeiou";
        String signos = "[$&+,:;=?@#|/\\'<>.-^*()%!]";

        for (int i = 0; i < spechar.length(); i++) {

            palabra = palabra.replace(spechar.charAt(i), chara.charAt(i));
        }

        for (int i = 0; i < signos.length(); i++) {

            palabra = palabra.replace(signos.charAt(i), ' ');
        }

        palabra = palabra.replace(" ", "");
        return palabra;
    }

    //Metodo que valida que un palíndromo cumpla las condiciones de uno

    public static boolean verificarLargo(String palabra) {

        return (palabra.length()) >= 2;
    }

    //Metodo que verifica que palabra es un palíndromo

    public static boolean verificarPalindromo(String palabra) {

        palabra = formatearTexto(palabra);
        StringBuilder palindromo = new StringBuilder(palabra);

        return palindromo.toString().equals(palindromo.reverse().toString()) && verificarLargo(palabra);
    }
}
