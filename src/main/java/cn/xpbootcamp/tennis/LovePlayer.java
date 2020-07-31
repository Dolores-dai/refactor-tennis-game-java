package cn.xpbootcamp.tennis;

public class LovePlayer extends Player {
    private String name;

    public LovePlayer(String name) {
        super(TennisScoreEnum.LOVE.point);
        this.name = name;
    }
}
