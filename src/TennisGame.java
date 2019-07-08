public class TennisGame {
    public static final int ADVANTAGESCORE = 4;
    public static final int ZEROSCORE = 0;
    public static final int FIFTEENSCORE = 1;
    public static final int THIRTYSCORE = 2;
    public static final int FORTYSCORE = 3;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = "";
        boolean deuce = player1Score == player2Score;
        if (deuce) {
            score=scoreIfDeuce(player1Score, score);
        } else {
            boolean advantage = player1Score >= ADVANTAGESCORE || player2Score >= ADVANTAGESCORE;
            if (advantage) {
                score=scoreIfAdvantage(player1Score, player2Score, score);
            } else {
               score= scoreInAnotherCase(player1Score, player2Score, score);
            }
        }
        return score;
    }

    private static String scoreIfAdvantage(int player1Score, int player2Score, String score) {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private static String scoreIfDeuce(int player1Score, String score) {
        switch (player1Score) {
            case ZEROSCORE:
                score = "Love-All";
                break;
            case FIFTEENSCORE:
                score = "Fifteen-All";
                break;
            case THIRTYSCORE:
                score = "Thirty-All";
                break;
            case FORTYSCORE:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    private static String scoreInAnotherCase(int player1Score, int player2Score, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                score += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }
}
