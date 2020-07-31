package cn.xpbootcamp.tennis;

public class FifteenPlayer extends Player {
    private String name;

    public FifteenPlayer(String name) {
        super(TennisScoreEnum.FIFTEEN.point);
        this.name = name;
    }
}
