package JavaThreadsPractice;

class DelayedTimer implements Runnable {
    private final int delayedTime;

    public DelayedTimer(int delayedTime) {
        this.delayedTime = delayedTime;
    }

    @Override
    public void run() {
        for (int i = 5; i <= delayedTime; i += 5) {
            try {
                Thread.sleep(5000);
                System.out.println("Пройшло 5 секунд");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
