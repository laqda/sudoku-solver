package solver;

import consts.Configuration;

import java.util.concurrent.TimeUnit;

public class Timer extends Thread {

    private SpeedLocker speedLocker;
    private Configuration.SPEED speed = Configuration.SPEED.LOW;

    public Timer(SpeedLocker locker) {
        this.speedLocker = locker;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.MILLISECONDS.sleep(this.speed.getSpeed());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            this.speedLocker.lock();
            this.speedLocker.signal();
            this.speedLocker.unlock();
        }
    }

    public void setSpeed(Configuration.SPEED speed) {
        this.speed = speed;
    }

    public Configuration.SPEED getSpeed() {
        return speed;
    }

}
