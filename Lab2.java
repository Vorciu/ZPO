
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Lab2 {

    static class MyThread extends Thread {

        String letters;
        int index;

        MyThread(String letters) {
            this.letters = letters;
        }

        @Override
        public void run() {
            while (index < letters.length()) {
                synchronized (queue) {
                    if (!queue.contains(this) || this == queue.get(0)) {

                        queue.removeIf(t -> t == this);

                        System.out.print(letters.charAt(index));
                        index++;
                        if (index < letters.length()) {
                            queue.add(this);
                        }
                        queue.notifyAll();
                        try {
                            if (index < letters.length() && (queue.size() > 1 || !didAnyThreadRun.getAndSet(true))) {
                                queue.wait();
                            }

                            //queue.put(lastThread);
                        } catch (InterruptedException e) {

                        }
                    }
                }
            }

        }

    }

    static List<MyThread> queue = new LinkedList<>();
    static AtomicBoolean didAnyThreadRun = new AtomicBoolean(false);

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        threadPool.submit(new MyThread("aaaa"));
        threadPool.submit(new MyThread("bb"));
        threadPool.submit(new MyThread("ccccccccccccc"));
        threadPool.submit(new MyThread("dddddd"));

//      MyThread a =  new MyThread("aaaa");
//      a.start();
//       new MyThread("bb").start();
//       new MyThread("ccccccccccccc").start();
//       new MyThread("dddddd").start();
//       
        threadPool.shutdown();

    }
}
