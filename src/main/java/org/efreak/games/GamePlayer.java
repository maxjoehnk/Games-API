package org.efreak.games;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.efreak.games.game.GameInstance;
import org.efreak.games.game.GameLobby;

public class GamePlayer {

	private boolean inGame = false;
	private boolean inLobby = false;
	private GameInstance game = null;
	private GameLobby lobby = null;
	private final Player player;
	
	public GamePlayer(Player player) {
		this.player = player;
	}
	
	public boolean isInGame() {
		return inGame;
	}
	
	public boolean isInLobby() {
		return inLobby;
	}
	
	public void setGame(GameInstance game) {
		this.game = game;
		if (game != null) inGame = true;
		else inGame = false;
	}
	
	public GameInstance getGame() {
		return game;
	}
	
	public void setLobby(GameLobby lobby) {
		this.lobby = lobby;
		if (lobby != null) inLobby = true;
		else inLobby = false;
	}
	
	public GameLobby getLobby() {
		return lobby;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setTeam(Team team) {
		Team oldTeam = getTeam();
		if (oldTeam != null) oldTeam.removePlayer(player);
		team.addPlayer(player);
	}
	
	public Team getTeam() {
		return player.getScoreboard().getPlayerTeam(player);
	}
	
	public void setScoreboard(Scoreboard scoreboard) {
		player.setScoreboard(scoreboard);
	}
	
	public Scoreboard getScoreboard() {
		return player.getScoreboard();
	}
}
