package solver;

import java.util.concurrent.TimeUnit;

public class Timer extends Thread {

    private TimeLocker locker;
    private int wait = 300;

    public Timer(TimeLocker locker) {
        this.locker = locker;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.MILLISECONDS.sleep(this.wait);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            this.locker.lock();
            this.locker.signal();
            this.locker.unlock();
        }
    }

    public void setWait(int wait) {
        this.wait = wait;
    }

}
