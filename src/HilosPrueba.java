public class HilosPrueba {
      public static void main(String[] args) throws InterruptedException {
        Thread hilo = new Thread(() -> {
            System.out.println("Hola desde el hilo");
        });

        hilo.start();   // arranca el hilo
        hilo.join();    // espera a que termine
        System.out.println("Listo");
    }
}
