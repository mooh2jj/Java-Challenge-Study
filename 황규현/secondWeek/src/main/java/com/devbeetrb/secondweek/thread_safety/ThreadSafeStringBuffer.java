package com.devbeetrb.secondweek.thread_safety;

public class ThreadSafeStringBuffer {
    public static void main(String[] args) throws InterruptedException {
        StringBuffer sf = new StringBuffer();

        Thread thread1 = new Thread(new MyRunnable(sf, "Is"));
        Thread thread2 = new Thread(new MyRunnable(sf, "Thread-Safe?"));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(sf.toString());
    }
}

class MyRunnable implements Runnable {
    private final StringBuffer sf;
    private final String str;

    public MyRunnable(StringBuffer sf, String str) {
        this.sf = sf;
        this.str = str;
    }

    public void run() {
        synchronized (sf) { // synchronize on the StringBuffer object
            for (int i = 0; i < 100; i++) {
                sf.append(str); // append the given string to the StringBuffer
            }
        }
    }
}