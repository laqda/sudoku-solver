package consts;

public class Configuration {

    private static final int DO_NOT_USE_TIMER = 0;
    private static final int slow = 1000;
    private static final int medium = 100;
    private static final int fast = 10;

    public enum SPEED {
        SLOW(slow), MEDIUM(medium), FAST(fast), STEP_BY_STEP(DO_NOT_USE_TIMER);
        private int speed;

        SPEED(int speed) {
            this.speed = speed;
        }

        public int getSpeed() {
            return speed;
        }

        public boolean shouldUseTimer() {
            return this.speed != DO_NOT_USE_TIMER;
        }

        public static SPEED getSpeed(int value) {
            switch (value) {
                case slow:
                    return SLOW;
                case medium:
                    return MEDIUM;
                case fast:
                    return FAST;
            }
            return STEP_BY_STEP;
        }
    }

}
