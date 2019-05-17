package solver;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SpeedLocker {

    private Lock lock;
    private Condition isReadyToContinue;

    public SpeedLocker() {
        this.lock = new ReentrantLock();
        this.isReadyToContinue = this.lock.newCondition();
    }

    public void lock() {
        this.lock.lock();
    }

    public void unlock() {
        this.lock.unlock();
    }

    public void await() {
        this.lock.lock();
        try {
            this.isReadyToContinue.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void signal() {
        this.isReadyToContinue.signal();
    }

}
