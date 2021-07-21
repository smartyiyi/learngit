package threads;

public class customer implements Runnable{


    private final Product product;

    public customer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {

       while (true){

            synchronized (product){

               if (product.num<5){

                   try {
                       product.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println("等待生产...");
               }

               System.out.println("消费完毕");
               product.num=0;

               product.notify();




            }

        }

    }
}
