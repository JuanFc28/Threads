import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Contador {
    private static int contador = 0;  // Variable compartida

    // Se usa synchronized para evitar accesos simultáneos inseguros
    public static synchronized void incrementar() {
        contador++;
    }

    public static int getValor() {
        return contador;
    }
}


public class Threads {
    public static void main(String[] args) throws Exception {

        // Lista de pedidos
        List<Pedido> pedidos = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            pedidos.add(new Pedido(i));
        }
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        long inicio = System.currentTimeMillis();

        //ejecucion de cada pedido
        for(Pedido pedido : pedidos){
            ProcesadorPedido proce = new ProcesadorPedido(pedido);
            Future<String> resultado = executor.submit(proce.processor);       
            System.out.println(resultado.get());   
        }
        
        long fin = System.currentTimeMillis();

        // Imprimir estadísticas
        System.out.println("Tiempo total de procesamiento: " + (fin - inicio) + " ms");
        System.out.println("Pedidos procesados con exito: "+Contador.getValor());

        // Apagar el ExecutorService
        executor.shutdown();
    }
}
