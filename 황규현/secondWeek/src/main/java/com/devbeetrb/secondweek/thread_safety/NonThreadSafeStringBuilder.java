package com.devbeetrb.secondweek.thread_safety;

public class NonThreadSafeStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(); // create a new StringBuilder object

        // 쓰레드 두개를 만들어서 실제로 StringBuilder에서 어떻게 결과 값이 나오나 확인
        Thread thread1 = new Thread(new MyRunnable2(sb, "Is"));
        Thread thread2 = new Thread(new MyRunnable2(sb, "Thread-Safe?"));

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // wait for the first thread to finish
            thread2.join(); // wait for the second thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(sb.toString());
    }
}
class MyRunnable2 implements Runnable {
    private final StringBuilder sb;
    private final String str;

    public MyRunnable2(StringBuilder sb, String str) {
        this.sb = sb;
        this.str = str;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            sb.append(str);
        }
    }
}