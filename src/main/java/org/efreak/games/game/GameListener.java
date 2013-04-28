package org.efreak.games.game;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public class GameListener implements Listener {

	private final Game game;
	
	public GameListener(Game game) {
		this.game = game;
	}
	
	public final void register() {
		Bukkit.getServer().getPluginManager().registerEvents(this, game.getPlugin());
	}
	
	public final void unregister() {
		HandlerList.unregisterAll(this);
	}
	
}
