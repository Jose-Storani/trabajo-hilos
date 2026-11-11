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

        // Si el usuario escribe 0 o un número negativo, usamos 1 hilo
        int cantidad = Math.max(1, hilos);

        File carpeta = new File(ruta);
        File[] elementos = carpeta.listFiles();

        if (elementos == null) {
            System.out.println("No se pudo leer la carpeta: " + carpeta.getAbsolutePath());
            return;
        }

        Thread[] lista = new Thread[cantidad];

        for (int i = 0; i < cantidad; i++) {
            final int inicio = i; //puse asi porque me tiraba error: local variables referenced from a lambda expression must be final or effectively final

            lista[i] = new Thread(() -> {
                for (int j = inicio; j < elementos.length; j += cantidad) {
                    //System.out.println(Thread.currentThread().getName() + " revisando j=" + j);
                    Buscador.revisar(elementos[j], nombre);
                }
            });

            lista[i].start();
        }

        for (Thread h : lista) {
            h.join();
        }

        if (!Buscador.encontrado) {
            System.out.println("No se encontró ningún archivo " + nombre);
}
    }
}