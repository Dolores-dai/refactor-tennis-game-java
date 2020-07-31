package cn.xpbootcamp.tennis;

public class SuperPlayer implements PlayerInterface {
    private final int point;
    private String name;
    private String res;

    public SuperPlayer(String name, int point, String res) {
        this.name = name;
        this.point = point;
        this.res = res;
    }

    @Override
    public int getPoint() {
        return point;
    }

    @Override
    public String getRes() {
        return res;
    }
}
