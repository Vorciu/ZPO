
public class Lab1 {

    static class MyThread extends Thread {

        final int threadId;
        MyThread waitForThread;

        MyThread(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            try {
                if (waitForThread != null) {
                    waitForThread.join();
                }
            } catch (InterruptedException ex) {

            }
            System.out.println("Thread " + threadId + " is running");

        }

    }

    public static void main(String[] args) {

        MyThread tab[] = new MyThread[10];
        for (int i = 0; i < 10; i++) {

            tab[i] = new MyThread(i);
            if (i > 0) {
                tab[i - 1].waitForThread = tab[i];
            }

        }

        for (int i = 0; i < 10; i++) {

            tab[i].start();
        }

    }

}
