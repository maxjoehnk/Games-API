package org.efreak.games.game;

import java.util.ArrayList;
import java.util.List;

import org.efreak.games.Configuration;
import org.efreak.games.GamePlayer;
import org.efreak.games.Games;
import org.efreak.games.game.actions.PlayerJoinAction;
import org.efreak.games.game.actions.PlayerLeaveAction;
import org.efreak.games.game.rules.ClassRule;
import org.efreak.games.game.rules.GameRule;
import org.efreak.games.game.rules.MaxPlayerRule;
import org.efreak.games.game.rules.MinPlayerRule;
import org.efreak.games.game.rules.RulesList;

public abstract class GameInstance {

	private static Configuration config;
	
	private boolean isRunning = false;
	private boolean lobbyEnabled = true;
	private final Game game;
	private final List<GamePlayer> players;
	private final RulesList rules;
	private GameLobby lobby;
	private String id, configPath;
	
	static {
		config = Games.getConfiguration();
	}
	
	public GameInstance(Game game, String id, boolean setupConfig) {
		this.game = game;
		players = new ArrayList<GamePlayer>();
		rules = new RulesList();
		rules.addAll(game.getRules());
		this.id = id;
		configPath = "Games." + game.getName() + ".Instances." + id + ".";
		if (setupConfig) {
			if (config.contains(configPath + "Lobby.Enabled"))
				lobbyEnabled = config.getBoolean(configPath + "Lobby.Enabled");
			if (config.contains(configPath + "Classes")) {
				List<PlayerClass> classes = new ArrayList<PlayerClass>();
				for (String className : config.getChilds(configPath + "Classes")) {
					classes.add(new PlayerClass(configPath + "Classes." + className));
				}
				rules.replace(new ClassRule(classes));
			}
			if (config.contains(configPath + "Players.Max"))
				rules.replace(new MaxPlayerRule(config.getInt(configPath + "Players.Max")));
			if (config.contains(configPath + "Players.Min")) {
				rules.replace(new MinPlayerRule(config.getInt(configPath + "Players.Min")));
			}
		}
	}
	
	public abstract boolean start();
	public abstract void stop();
	
	public Game getGame() {
		return game;
	}
	
	public String getId() {
		return id;
	}
	
	public boolean join(GamePlayer player) {
		for (GameRule rule : rules) {
			if (!rule.isActionValid(this, new PlayerJoinAction(player))) return false;
		}
		players.add(player);
		player.setGame(this);
		if (lobbyEnabled) player.setLobby(lobby);
		return true;
	}
	
	public boolean leave(GamePlayer player) {
		for (GameRule rule : rules) {
			if (!rule.isActionValid(this, new PlayerLeaveAction(player))) return false;
		}
		player.leaveGame();
		players.remove(player);
		return true;
	}
	
	public List<GamePlayer> getPlayers() {
		return players;
	}
	
	public void removeRule(GameRule rule) {
		rules.remove(rule);
	}
	
	public void addRule(GameRule rule) {
		rules.add(rule);
	}
	
	public boolean isRunning() {
		return isRunning;
	}
	
	public void setLobby(GameLobby lobby) {
		this.lobby = lobby;
	}

	public GameLobby getLobby() {
		return lobby;
	}
}