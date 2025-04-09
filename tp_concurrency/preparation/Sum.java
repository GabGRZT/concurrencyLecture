package tp_concurrency.preparation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sum {

    public void countTo(int n){
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()-> {
            int sum = 0;
            System.out.println("Démarrage...");
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            System.out.println("La somme des 10 premiers entiers est égale à "+sum);
        });
    }

    public static void main(String[] args) {
        Sum sum = new Sum();
        sum.countTo(10);

    }

}
