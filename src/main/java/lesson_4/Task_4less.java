package lesson_4;

public class Task_4less {

    volatile int status = 0;
    public static void main(String[] args) {
        Task_4less lock = new Task_4less();
        Thread t1 = new Thread(new Task("A", lock,1));
        Thread t2 = new Thread(new Task("B", lock,2));
        Thread t3 = new Thread(new Task("C", lock,3));
        t1.start();
        t2.start();
        t3.start();
    }
}

