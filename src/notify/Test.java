package notify;

public class Test {
    public static void main(String[] args) {
        Goods goods = new Goods();
        ProThread proThread = new ProThread(goods);
        CusThread cusThread = new CusThread(goods);
        Thread thread = new Thread(proThread);
        Thread thread1 = new Thread(cusThread);
        thread.start();
        thread1.start();
    }
}
