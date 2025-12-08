public class Game {
    private int gameId;
    private String gameTitle;

    public Game(int gameId, String gameTitle) {
        this.gameId = gameId;
        this.gameTitle = gameTitle;
    }

    public int getGameId() { return this.gameId; }
    public String getGameTitle() { return this.gameTitle; }

    public void setGameId(int gameId) { this.gameId = gameId; }
}
