package epam.com.atm.waiters;

public class Waiter {
    public static void waitExplicit() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
