import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {


        new Thread1().start();

        new Thread2().start();

    }

    static class Thread1 extends Thread {
        @Override
        public void run() {


            System.out.println(getName() + " Start working");
            lock.lock();
            for (int i = 0; i < 3; i++) {
                System.out.println(getName() + " im working");
            }

            System.out.println(getName() + " Stop working");
            System.out.println(getName() + " finish");
            lock.unlock();


        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            System.out.println(getName() + " Start working");
            while (true) {
                if (lock.tryLock()) {

                    for (int i = 0; i < 3; i++) {
                        System.out.println(getName() + " im working");
                    }
                    break;
                } else {
                    System.out.println(getName() + " im waiting");
                }
            }
        }
    }
}

