import java.io.File;

public class Buscador {
    public static boolean encontrado = false; 
    public static void buscar(File carpeta, String nombre) {
        
        File[] elementos = carpeta.listFiles(); 

        if (elementos == null) {
            return;
        }

        for (File elemento : elementos) {
            revisar(elemento,nombre);
        }
    }

    public static void revisar(File elemento, String nombre){
      if (elemento.isDirectory()) {
                buscar(elemento, nombre); // entra en la subcarpeta
            } else if (elemento.getName().equals(nombre)) {
                System.out.println(elemento.getAbsolutePath());
                encontrado = true;
            }

    }
}
