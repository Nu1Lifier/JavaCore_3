public class Task implements Runnable{



    private String message;
    private final Task_4less lock;
    private int p;

    Task(String text, Task_4less obj, int p) {
        message = text;
        this.lock = obj;
        this.p = p;
    }

    @Override
    public void run() {

        while(lock.status < 13) {
            synchronized (lock) {

                while(!((lock.status % 3) == 0) && p == 1){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                while(!((lock.status % 3) == 1) && p == 2){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                while(!((lock.status % 3) == 2) && p == 3){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(message);
                lock.status++;
                if ((lock.status % 3) == 0) System.out.println("---");
                lock.notifyAll();
            }
        }
    }
}
