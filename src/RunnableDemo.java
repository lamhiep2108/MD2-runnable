public class RunnableDemo implements Runnable {
    private Thread t;
    private final String threadName;

    RunnableDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }
    @Override
    public void run() {
        System.out.println("running " +  threadName);
        for (int i = 4; i >0 ; i--) {
            System.out.println("thread " + threadName+","+i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadName + " interrupted.");
            }
            System.out.println("Thread " + threadName + " exiting.");

        }
    }
    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public static void main(String[] args) {
        System.out.println("main thread running....");
        RunnableDemo runnableDemo=new RunnableDemo("Thread-1-HR-Database");
        runnableDemo.start();
        RunnableDemo runnableDemo1=new RunnableDemo("Thread-2-HR-Database");
        runnableDemo1.start();
        System.out.println("Main thread stopped!!! ");
    }
}
