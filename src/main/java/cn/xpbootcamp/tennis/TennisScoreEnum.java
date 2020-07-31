package cn.xpbootcamp.tennis;

import java.util.HashMap;
import java.util.Map;

public enum TennisScoreEnum {
    LOVE("Love", 0),
    FIFTEEN("Fifteen", 1),
    THIRTY("Thirty", 2),
    FORTY("Forty", 3);

    private static final Map<String, Integer> SCORE_MAP_POINT = new HashMap<>();
    private static final Map<Integer, String> POINT_MAP_SCORE = new HashMap<>();
    private static final Map<Integer, TennisScoreEnum> POINT_MAP_TENNIS_SCORE_ENUM = new HashMap<>();

    static {
        for (TennisScoreEnum tennisScoreEnum : values()) {
            SCORE_MAP_POINT.put(tennisScoreEnum.score, tennisScoreEnum.point);
            POINT_MAP_SCORE.put(tennisScoreEnum.point, tennisScoreEnum.score);
            POINT_MAP_TENNIS_SCORE_ENUM.put(tennisScoreEnum.point, tennisScoreEnum);
        }
    }

    public final String score;
    public final Integer point;

    TennisScoreEnum(String score, Integer point) {
        this.score = score;
        this.point = point;
    }

    public static int getPointByScore(String score) {
        return SCORE_MAP_POINT.get(score);
    }

    public static String getScoreByPoint(Integer point) {
        return POINT_MAP_SCORE.get(point);
    }
}
