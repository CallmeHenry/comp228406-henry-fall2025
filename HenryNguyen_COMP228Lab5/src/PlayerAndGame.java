import java.sql.Date;

public class PlayerAndGame {
    private int playerGameId, gameId, playerId, score;
    private Date playingDate;

    public PlayerAndGame(int playerGameId, int gameId, int playerId, int score, Date playingDate) {
        this.playerGameId = playerGameId;
        this.gameId = gameId;
        this.playerId = playerId;
        this.score = score;
        this.playingDate = playingDate;
    }

    public int getPlayerGameId() { return playerGameId; }
    public int getGameId() { return gameId; }
    public int getPlayerId() { return playerId; }
    public int getScore() { return score; }
    public Date getPlayingDate() { return playingDate; }

    public void setPlayerGameId(int id) { this.playerGameId = id; }

}
