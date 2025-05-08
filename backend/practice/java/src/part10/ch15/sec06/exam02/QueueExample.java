package part10.ch15.sec06.exam02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Message> queue = new LinkedList<>();

        queue.add(new Message("sendMail", "홍길동"));
        queue.add(new Message("sendSMS", "신용권"));
        queue.add(new Message("sendKakaotalk", "감자바"));

        while (queue.isEmpty() == false) {
           Message message = queue.poll();
            String str = null;
            if (message.command.equals("sendMail"))
                str = "메일을";
            else if (message.command.equals("sendSMS"))
                str = "SMS를";
            else
                str = "카카오톡을";
            System.out.println(message.to + "님에게 " + str + " 보냅니다.");
        }
    }
}
