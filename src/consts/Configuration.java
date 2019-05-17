package consts;

public class Configuration {

    public static final int TIMER_WAIT = 1;

    public enum SPEED {
        LOW(1000), MEDIUM(100), FAST(10), STEP_BY_STEP;
        private int speed;

        SPEED() {
        }

        SPEED(int speed) {
            this.speed = speed;
        }

        public int getSpeed() {
            return speed;
        }
    }

}
