public class GameEvaluator {
    public GameResult evaluate(int playerValue, int cpuValue) {
        if (playerValue > 21) return GameResult.PLAYER_BUST;
        if (cpuValue > 21) return GameResult.CPU_BUST;
        if (playerValue == 21 && cpuValue != 21) return GameResult.PLAYER_WIN;
        if (cpuValue == 21 && playerValue != 21) return GameResult.CPU_WIN;
        if (playerValue == cpuValue) return GameResult.TIE;
        if (playerValue > cpuValue) return GameResult.PLAYER_WIN;
        return GameResult.CPU_WIN;
    }
}