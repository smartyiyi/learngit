package notify;

public class ProThread implements Runnable{
    private final Goods goods;

    public ProThread(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true){
            synchronized (goods){
                if (goods.count==5) {
                    System.out.println("生产者等待生产...");
                    try {
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    System.out.println("生产者开始生产");
                    for (int i = 1; i <=5; i++) {
                        goods.count=i;
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("生产者生产了第"+i+"个商品");
                    }
                    System.out.println("生产完毕");
                    goods.notify();


            }
        }
    }
}
