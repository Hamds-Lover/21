public class CpuDecisionMaker {
    public boolean shouldHit(int cpuHandValue, int playerVisibleTotal) {
        // Aggressive if player visible total is 11 or more
        if (playerVisibleTotal >= 11) {
            return cpuHandValue < 17;
        } else {
            return cpuHandValue < 12;
        }
    }
}