package org.efreak.games.game;

import java.util.ArrayList;
import java.util.List;

import org.efreak.games.GamePlayer;
import org.efreak.games.game.actions.PlayerJoinAction;
import org.efreak.games.game.actions.PlayerLeaveAction;
import org.efreak.games.game.rules.GameRule;

public abstract class GameInstance {

	private final Game game;
	private final List<GamePlayer> players;
	
	public GameInstance(Game game) {
		this.game = game;
		players = new ArrayList<GamePlayer>();
	}
	
	public abstract boolean start();
	public abstract void stop();
	
	public Game getGame() {
		return game;
	}
	
	public boolean join(GamePlayer player) {
		for (GameRule rule : game.getRules()) {
			if (!rule.isActionValid(this, new PlayerJoinAction())) return false;
		}
		players.add(player);
		return true;
	}
	
	public boolean leave(GamePlayer player) {
		for (GameRule rule : game.getRules()) {
			if (!rule.isActionValid(this, new PlayerLeaveAction())) return false;
		}
		players.remove(player);
		return true;
	}
	
	public List<GamePlayer> getPlayers() {
		return players;
	}
}
