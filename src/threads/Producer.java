package threads;

public class Producer implements Runnable{

    private final Product product;

    public Producer(Product product) {
        this.product = product;
    }


    @Override
    public void run() {

        while (true){


            synchronized (product) {


                if (product.num == 5) {

                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 1; i <=5 ; i++) {
                    product.num=i;
                    System.out.println("生产者生产了" + i + "件商品");
                }

                product.notify();
                System.out.println("通知生产者消费");

            }

        }
    }

}
