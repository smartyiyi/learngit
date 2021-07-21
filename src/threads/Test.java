package threads;

public class Test {
    public static void main(String[] args) {
        Product product = new Product();
        Producer producer = new Producer(product);
        customer customer = new customer(product);
        new Thread(producer).start();
        new Thread(customer).start();
    }
}
