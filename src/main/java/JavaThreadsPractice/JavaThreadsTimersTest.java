package JavaThreadsPractice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaThreadsTimersTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int time;
        int delayedTime;

        while (true) {
            try {
                System.out.print("Enter Time For Timer: ");
                time = scanner.nextInt();
                System.out.print("Enter Time For DelayedTimer: ");
                delayedTime = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entered Wrong Input! Time For Timer And DelayedTimer Must Be Integer.");
                scanner.nextLine();
            }
        }

        Timer timer = new Timer(time);
        Thread delayedTimer = new Thread(new DelayedTimer(delayedTime));

        timer.start();
        delayedTimer.start();

        scanner.close();
    }
}
