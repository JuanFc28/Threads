import java.util.concurrent.Callable;

public class ProcesadorPedido  {
    Pedido pedido;
    public ProcesadorPedido(Pedido pedido){
        this.pedido = pedido;
    }
    Callable<String> processor = () -> {
        return pedido.run();  // Operación dentro del hilo
    };
}
