package org.efreak.games.game;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.efreak.games.game.events.GameStartEvent;
import org.efreak.games.game.events.GameStopEvent;
import org.efreak.games.game.rules.GameRule;

public abstract class Game {

	private String name, desc;
	private Plugin plugin;
	private List<GameListener> listener;
	private HashMap<String, GameInstance> instances;
	private List<GameRule> rules;
	
	public abstract void load();
	public abstract GameInstance createInstance();
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public Plugin getPlugin() {
		return plugin;
	}
	
	public List<GameRule> getRules() {
		return rules;
	}
	
	public boolean startGame(String id, GameInstance instance) {
		if (instances.isEmpty()) {
			for (GameListener l : listener) l.register();
		}
		if (instance.start()) {
			instances.put(id, instance);
			GameStartEvent event = new GameStartEvent(id, instance);
			Bukkit.getServer().getPluginManager().callEvent(event);
			return true;
		}else return false;
	}
	
	public void stopGame(String id) {
		instances.get(id).stop();
		GameStopEvent event = new GameStopEvent(id, instances.get(id));
		Bukkit.getServer().getPluginManager().callEvent(event);
		instances.remove(id);
		if (instances.isEmpty()) {
			for (GameListener l : listener) l.unregister();
		}		
	}
	
}
