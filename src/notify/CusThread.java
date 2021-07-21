package notify;

public class CusThread implements Runnable{
    private final Goods goods;

    public CusThread(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true){
            synchronized (goods){
                if (goods.count<5){
                    try {
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("消费者等待消费...");
                }
                System.out.println("消费者开始消费...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者消费完毕...");
                goods.count=0;
                goods.notify();

            }
        }
    }
}
