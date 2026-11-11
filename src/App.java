import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {
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
        int cantidad_hilos = Math.max(1, hilos); //evito el 0, siempre se usa 1

        File carpeta = new File(ruta);
        File[] elementos = carpeta.listFiles();
        Thread[] lista = new Thread[cantidad_hilos];
        for (int i = 0; i < cantidad_hilos; i++){
            int inicio = i;
            lista[0] = new Thread(() -> {

            });

        }
    }
}