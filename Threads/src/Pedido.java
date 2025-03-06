import java.util.concurrent.ThreadLocalRandom;

public  class Pedido{
    int id;

    public Pedido(int id){
        this.id = id;
        
    }

    public String run(){
        
        try {
            // Generar un número aleatorio entre 1000 y 5000 milisegundos (1 a 5 segundos)
            int randomSleepTime = ThreadLocalRandom.current().nextInt(1000, 10000);
            Thread.sleep(randomSleepTime);
            Contador.incrementar();
            return "Pedido " + id + " procesado con éxito" + ". Tiempo tomado: "+randomSleepTime+" ms";
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Pedido " + id + " no pudo ser procesado";
        }
        
    }
}
