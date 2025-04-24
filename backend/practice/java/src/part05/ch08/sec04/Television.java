package part05.ch08.sec04;

public class Television implements RemoteControl {
    private int volume;

    public Television(int volume) {
        turnOn();
        setVolume(volume);
        turnOff();
    }

    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if (volume > MAX_VOLUME)
            this.volume = MAX_VOLUME;
        else
            this.volume = Math.max(volume, MIN_VOLUME);

        System.out.println("현재 TV 볼륨: " + this.volume);
    }
}
