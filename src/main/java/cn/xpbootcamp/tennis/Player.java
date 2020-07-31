package cn.xpbootcamp.tennis;

public class Player implements PlayerInterface {
    private final int point;
    private final String res;


    Player(int point) {
        this.point = point;
        res = TennisScoreEnum.getScoreByPoint(point);
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
