package org.efreak.games.game.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.efreak.games.game.Game;
import org.efreak.games.game.GameInstance;

public class GameStopEvent extends Event {

	private static final HandlerList handlers = new HandlerList();
	private GameInstance instance;
	private String id;
	
	public GameStopEvent(String id, GameInstance instance) {
		this.instance = instance;
		this.id = id;
	}
	
	public GameInstance getGameInstance() {
		return instance;
	}
	
	public Game getGame() {
		return instance.getGame();
	}
	
	public String getId() {
		return id;
	}
	
	public String getCause() {
		return "";
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}
}
