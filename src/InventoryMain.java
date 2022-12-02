import java.util.concurrent.Semaphore;
import java.lang.Math;

//Main class to run the program "InventoryMain" act as Driver Class
public class InventoryMain {

    public static int invent; //Public resource that shared by two classes "Addition" and "Subtraction"


    public static void main(String[] args) throws InterruptedException {

        //Constructor with Parameter (Addition Input, Subtraction Input, Bug Flag)
        Inventory inventory = new Inventory((args[0]), (args[1]), (args[2]));

        //Calling out classes and starting few different threads that run concurrently
        Addition addition = new Addition(inventory);
        Thread ta = new Thread(addition);

        Subtraction subtraction = new Subtraction(inventory);
        Thread ts = new Thread(subtraction);

        // Starts both threads
        ta.start();
        ts.start();

        //Wait until another thread completes its execution and prints the final inventory size
        ta.join();
        ts.join();


        System.out.println("Final Inventory Size is :" + InventoryMain.invent);


    }
}

//Class for setter, get the user input from the terminal
class Inventory implements Runnable {

    private static int add;
    private static int sub;
    private static int bug;


    @Override
    public void run() {

    }

    public Inventory(String plus, String minus, String bug) {
        Inventory.add = Integer.parseInt(plus);
        Inventory.sub = Integer.parseInt(minus);
        Inventory.bug = Integer.parseInt(bug);
    }

    public static int getAdd() {
        return add;

    }

    public static int getSub() {
        return sub;
    }

    public static int getBug() {
        return bug;
    }
}

class Addition implements Runnable {

    //Variables for bug flag
    private int max = 5;
    private int min = 2;
    private int range = max - min + 1;
    private int random;

    // Private Counter to perform the addition
    private static int counter = 0;

    //Semaphores only allow one thread to operate
    private static Semaphore sema = new Semaphore(1);

    public Addition(Inventory invent) {

    }

    @Override
    public synchronized void run() {

        //When the bug flag is set to 0, the program must come out with the correct output
        while (Inventory.getBug() == 0) {

            try {
                sema.acquire();
                if (counter != Inventory.getAdd()) {
                    counter++;
                    InventoryMain.invent++;
                    System.out.println("Added: " + InventoryMain.invent);
                    Thread.sleep(80);
                    continue;

                }

            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            } finally {
                sema.release();
            }
            return;
        }

        //Generates a random number to variable Random ranged from 2 to 10
        //It will delete the inventory with random number which caused the final inventory is wrong
        for (int i = 0; i < 10; i++) {
            random = (int) (Math.random() * range) + min;
        }

        //When the bug flag is set to 1, the program must come out with the wrong output
        while (Inventory.getBug() == 1) {


            try {
                sema.acquire();
                if (counter != Inventory.getAdd()) {
                    counter++;
                    InventoryMain.invent = InventoryMain.invent + random;
                    System.out.println("Added: " + InventoryMain.invent);
                    Thread.sleep(80);
                    continue;

                }

            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            } finally {
                sema.release();
            }
            return;
        }


    }

}

class Subtraction implements Runnable {

    // Variables for bug flag
    private int max = 5;
    private int min = 2;
    private int range = max - min + 1;
    private int random;

    //Private counter to perform the subtraction
    private static int counter = 0;

    //Semaphores only allow one thread to operate
    private static Semaphore sema = new Semaphore(1);

    public Subtraction(Inventory invent) {
    }


    @Override
    public synchronized void run() {

        //When the bug flag is set to 0, the program must come out with the wrong output
        while (Inventory.getBug() == 0) {

            try {
                sema.acquire();


                if (counter != Inventory.getSub()) {
                    counter++;
                    InventoryMain.invent--;
                    System.out.println("Removed: " + InventoryMain.invent);
                    Thread.sleep(80);
                    continue;
                }

            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            } finally {
                sema.release();
            }
            return;

        }

        //Generates a random number to variable Random ranged from 2 to 10
        //It will delete the inventory with random number which caused the final inventory is wrong
        for (int i = 0; i < 10; i++) {
            random = (int) (Math.random() * range) + min;
        }

        //When the bug flag is set to 1, the program must come out with the wrong output


        while (Inventory.getBug() == 1) {

            try {
                sema.acquire();
                if (counter != Inventory.getSub()) {
                    counter++;
                    InventoryMain.invent = InventoryMain.invent - random;
                    System.out.println("Removed: " + InventoryMain.invent);
                    Thread.sleep(80);
                    continue;

                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            } finally {
                sema.release();
            }
            return;

        }


    }
}



