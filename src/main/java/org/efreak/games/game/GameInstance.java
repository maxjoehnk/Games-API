package org.efreak.games.game;

import java.util.ArrayList;
import java.util.List;

import org.efreak.games.Configuration;
import org.efreak.games.GamePlayer;
import org.efreak.games.Games;
import org.efreak.games.game.actions.PlayerJoinAction;
import org.efreak.games.game.actions.PlayerLeaveAction;
import org.efreak.games.game.rules.GameRule;

public abstract class GameInstance {

	private static Configuration config;
	
	private boolean isRunning = false;
	private final Game game;
	private final List<GamePlayer> players;
	private final List<GameRule> rules;
	private GameLobby lobby;
	private String id, configPath;
	
	static {
		config = Games.getConfiguration();
	}
	
	public GameInstance(Game game, String id) {
		this.game = game;
		players = new ArrayList<GamePlayer>();
		rules = new ArrayList<GameRule>();
		rules.addAll(game.getRules());
		this.id = id;
		configPath = "Games." + game.getName() + ".Instances." + id + ".";
		
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
		return true;
	}
	
	public boolean leave(GamePlayer player) {
		for (GameRule rule : rules) {
			if (!rule.isActionValid(this, new PlayerLeaveAction(player))) return false;
		}
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