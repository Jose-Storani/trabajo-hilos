import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingresá la ruta donde buscar (vacío = carpeta actual): ");
        String ruta = entrada.nextLine();

        if (ruta.isEmpty()) {
            ruta = ".";
        }

        System.out.print("Nombre del archivo a buscar: ");
        String nombre = entrada.nextLine();

        System.out.print("Cantidad de hilos: ");
        int hilos = entrada.nextInt();

        entrada.close();

        File carpeta = new File(ruta);
        Buscador.buscar(carpeta, nombre);
    }
}