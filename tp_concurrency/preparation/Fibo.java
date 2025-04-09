package tp_concurrency.preparation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Fibo {

    public long soumettre(int n) {
        ExecutorService service = Executors.newCachedThreadPool();

        Callable<Long> callable = () -> {
            System.out.println("Démarrage du calcul de Fibonacci pour n = " + n);
            return fibonacci(n);
        };

        Future<Long> future = service.submit(callable);

        long result = 0;
        try {
            result = future.get();
            System.out.println("Résultat pour n = " + n + " : " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        service.shutdown();
        return result;
    }

    public long fibonacci(int n) {
        if (n < 2) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Fibo fibo = new Fibo();

        fibo.soumettre(10);
        fibo.soumettre(43);
        fibo.soumettre(53);
    }
}
