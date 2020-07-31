package cn.xpbootcamp.tennis;

public class FortyPlayer extends Player {
    private String name;

    public FortyPlayer(String name) {
        super(TennisScoreEnum.FORTY.point);
        this.name = name;
    }
}
