package cn.xpbootcamp.tennis;

public class ThirtyPlayer extends Player {
    private String name;

    public ThirtyPlayer(String name) {
        super(TennisScoreEnum.THIRTY.point);
        this.name = name;
    }
}
