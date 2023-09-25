package diningphilosophers;



import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {

    private final Lock verrou = new ReentrantLock();




    private static int stickCount = 0;

    private final int myNumber;

    public ChopStick() {
        myNumber = ++stickCount;
    }



    public boolean tryTake(int delay) throws InterruptedException {
        return verrou.tryLock(100, TimeUnit.MILLISECONDS);


    }

    public void release() {
        verrou.unlock();
        System.out.println("Stick " + myNumber + " Released");
    }

    @Override
    public String toString() {
        return "Stick#" + myNumber;
    }
}
