package part08.ch14.sec03.exam02;

import java.awt.Toolkit;
import java.sql.SQLOutput;

public class BeepPrintExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                while (true) {
                    toolkit.beep();
                    try {
                        Thread.sleep(500);
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });

        thread.start();

        while (true) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
