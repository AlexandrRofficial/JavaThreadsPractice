package JavaThreadsPractice;

public class JavaThreadsFizzBuzzThreadsTest {
    public static void main(String[] args) {
        int n = 15;

        FizzBuzzThreads fizzBuzzThreads = new FizzBuzzThreads(n);

        Thread threadFizz = new Thread(() -> {
            try {
                fizzBuzzThreads.fizz();
            } catch (Exception e) {}
        });

        threadFizz.start();

        Thread threadBuzz = new Thread(() -> {
            try {
                fizzBuzzThreads.buzz();
            } catch (Exception e) {}
        });

        threadBuzz.start();

        Thread threadFizzbuzz = new Thread(() -> {
            try {
                fizzBuzzThreads.fizzbuzz();
            } catch (Exception e) {}
        });

        threadFizzbuzz.start();

        Thread threadNumber = new Thread(() -> {
            try {
                fizzBuzzThreads.number();
            } catch (Exception e) {}
        });

        threadNumber.start();
    }
}
