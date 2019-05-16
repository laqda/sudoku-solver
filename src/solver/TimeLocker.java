package solver;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLocker {

    private Lock lock;
    private Condition isReadyToContinue;

    public TimeLocker() {
        this.lock = new ReentrantLock();
        this.isReadyToContinue = this.lock.newCondition();
    }

    public void lock() {
        this.lock.lock();
    }

    public void unlock() {
        this.lock.unlock();
    }

    public void await() throws InterruptedException {
        this.isReadyToContinue.await();
    }

    public void signal() {
        this.isReadyToContinue.signal();
    }

}
