package JavaThreadsPractice;

import java.util.LinkedList;
import java.util.Queue;

class FizzBuzzThreads {
    private int n;
    private int current = 1;
    private final Queue<String> queue = new LinkedList<>();

    public FizzBuzzThreads(int n) {
        this.n = n;
    }

    public synchronized void fizz() throws InterruptedException {
        while (current <= n) {
            if (current % 3 == 0 && current % 5 != 0) {
                queue.add("fizz");
                current++;
                notifyAll();
            } else {
                wait();
                if (current > n) {
                    return;
                }
            }
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (current <= n) {
            if (current % 5 == 0 && current % 3 != 0) {
                queue.add("buzz");
                current++;
                notifyAll();
            } else {
                wait();
                if (current > n) {
                    return;
                }
            }
        }
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while (current <= n) {
            if (current % 3 == 0 && current % 5 == 0) {
                queue.add("fizzbuzz");
                current++;
                notifyAll();
            } else {
                wait();
                if (current > n) {
                    return;
                }
            }
        }
    }

    public synchronized void number() throws InterruptedException {
        while (current <= n || !queue.isEmpty()) {
            if (current <= n && current % 3 != 0 && current % 5 != 0) {
                queue.add(String.valueOf(current));
                current++;
                notifyAll();
            } else if (current <= n && queue.isEmpty()) {
                wait();
                continue;
            }

            while (!queue.isEmpty()) {
                String item = queue.poll();

                if (current > n && queue.isEmpty()) {
                    System.out.print(item);
                } else {
                    System.out.print(item + ", ");
                }
            }

            if (current > n && queue.isEmpty()) {
                System.out.println();
                break;
            }
        }
    }
}
