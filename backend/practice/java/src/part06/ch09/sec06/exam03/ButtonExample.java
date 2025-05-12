package part06.ch09.sec06.exam03;

import part06.ch09.sec06.exam01.Button;

public class ButtonExample {
    public static void main(String[] args) {
        class OkListener implements Button.ClickListener {
            @Override
            public void onClick() {
                System.out.println("Ok 버튼을 클릭했습니다.");
            }
        }

        OkListener listener = new OkListener();
        listener.onClick();
    }
}
