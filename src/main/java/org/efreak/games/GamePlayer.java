package org.efreak.games;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.efreak.games.game.GameInstance;
import org.efreak.games.game.GameLobby;
import org.efreak.games.game.PlayerClass;

public class GamePlayer {

	private boolean inGame = false;
	private boolean inLobby = false;
	private GameInstance game = null;
	private GameLobby lobby = null;
	private final Player player;
	private PlayerClass playerClass = null;
	private ItemStack[] invBackup;
	private ItemStack[] armorBackup;
		
	public GamePlayer(Player player) {
		this.player = player;
		invBackup = player.getInventory().getContents();
		armorBackup = player.getInventory().getArmorContents();
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
	
	public PlayerClass getPlayerClass() {
		return playerClass;
	}
	
	public void setPlayerClass(PlayerClass playerClass) {
		this.playerClass = playerClass;
	}
	
	public void equipClass() {
		backupInventory();
		if (playerClass != null) playerClass.equip(player);
	}
	
	public void backupInventory() {
		invBackup = player.getInventory().getContents();
		armorBackup = player.getInventory().getArmorContents();
	}
	
	public void restoreInventory() {
		player.getInventory().clear();
		player.getInventory().setContents(invBackup);
		player.getInventory().setArmorContents(armorBackup);
	}
}
