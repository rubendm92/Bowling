package bowling;

public class PlayerScore {

    private final String playerName;

    public PlayerScore(String playerName) {
        this.playerName = playerName;
    }
    
    public String getPlayerName() {
        return playerName;
    }

    public void addThrow(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getScore() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
