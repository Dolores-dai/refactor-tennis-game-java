package cn.xpbootcamp.tennis;

public class TennisGameImpl implements TennisGame {
    private int P1point = 0;
    private int P2point = 0;

    private String P1res = "";
    private String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public PlayerInterface convertToDetailType(int point, String playerName) {
        if (point == TennisScoreEnum.LOVE.point) {
            return new LovePlayer(playerName);
        }
        if (point == TennisScoreEnum.FIFTEEN.point) {
            return new FifteenPlayer(playerName);
        }
        if (point == TennisScoreEnum.THIRTY.point) {
            return new ThirtyPlayer(playerName);
        }
        if (point == TennisScoreEnum.FORTY.point) {
            return new FortyPlayer(playerName);
        }
        if (point == 4) {
            return new SuperPlayer(playerName, point, "Win for ");
        }
        return new SuperPlayer(playerName, point, "Advantage ");
    }

    public String getScore() {
        PlayerInterface player1 = convertToDetailType(P1point, player1Name);
        PlayerInterface player2 = convertToDetailType(P2point, player2Name);
        String score = "";

        score = getOneLoveScore(player1, player2);

        score = getSameScore(player1, player2);

        if (P1point > P2point && P1point < 4) {
            if (P1point == 2)
                P1res = "Thirty";
            if (P1point == 3)
                P1res = "Forty";
            if (P2point == 1)
                P2res = "Fifteen";
            if (P2point == 2)
                P2res = "Thirty";
            score = player1.getRes() + "-" + player2.getRes();
        }
        if (P2point > P1point && P2point < 4) {
            if (P2point == 2)
                P2res = "Thirty";
            if (P2point == 3)
                P2res = "Forty";
            if (P1point == 1)
                P1res = "Fifteen";
            if (P1point == 2)
                P1res = "Thirty";
            score = player1.getRes() + "-" + player2.getRes();
        }

        if (P1point > P2point && P2point >= 3) {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3) {
            score = "Advantage player2";
        }

        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }

        return score;
    }

    private String getSameScore(PlayerInterface player1, PlayerInterface player2) {
        if (player1.getPoint() == player2.getPoint()) {
            if (player1.getPoint() < 3) {
                return getEqualScoreLessThanFour();
            } else return "Deuce";
        }
        return "";
    }

    private String getOneLoveScore(PlayerInterface player1, PlayerInterface player2) {
        if (player1 instanceof LovePlayer && !(player2 instanceof LovePlayer)) {
            return player1.getRes() + "-" + player2.getRes();
        }
        if (player2 instanceof LovePlayer && !(player1 instanceof LovePlayer)) {
            return player2.getRes() + "-" + player1.getRes();
        }
        return "";
    }

    private String getEqualScoreLessThanFour() {
        return TennisScoreEnum.getScoreByPoint(P1point) + "-All";
    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}
