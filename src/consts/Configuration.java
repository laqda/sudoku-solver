package consts;

public class Configuration {

    private static final int DO_NOT_USE_TIMER = 0;

    public enum SPEED {
        LOW(1000), MEDIUM(100), FAST(10), STEP_BY_STEP(DO_NOT_USE_TIMER);
        private int speed;

        private SPEED(int speed) {
            this.speed = speed;
        }

        public int getSpeed() {
            return speed;
        }

        public boolean shouldUseTimer() {
            return this.speed != DO_NOT_USE_TIMER;
        }
    }

}
