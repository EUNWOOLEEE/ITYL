package part03.basic.ch06.sec08.exam02;

public class Computer {
    public int sum(int ... nums) {
        int res = 0;
        for (int n : nums)
            res += n;
        return res;
    }
}