package JavaThreadsPractice;

class Timer extends Thread {
    private final int time;

    public Timer(int time) {
        this.time = time;
    }

    @Override
    public void run() {
        for (int i = 0; i <= time; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
