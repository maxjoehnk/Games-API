package org.efreak.games.game;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.efreak.games.game.events.GameStartEvent;
import org.efreak.games.game.events.GameStopEvent;
import org.efreak.games.game.rules.GameRule;

/**
 * 
 * The Game class represents a specific Type of Game.
 * 
 * It is the base for the {@link org.efreak.games.game.GameInstance GameInstance} class.
 * One Plugin can register multiple Games, which can create multiple Instances. 
 *
 */
public abstract class Game {

	private String name, desc;
	private Plugin plugin;
	private List<GameListener> listener;
	private HashMap<String, GameInstance> instances;
	private List<GameRule> rules;
	
	/**
	 * 
	 * Load everything which is needed for the game
	 * 
	 */
	public abstract void load();
	
	/**
	 * 
	 * Create a new GameInstance
	 * 
	 * @return the created Instance
	 */
	public abstract GameInstance createInstance();
	
	/**
	 * 
	 * @return The Name of the Game
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return The Description of the Game
	 */
	public String getDesc() {
		return desc;
	}
	
	/**
	 * 
	 * @return The Plugin this game was registered by
	 */
	public Plugin getPlugin() {
		return plugin;
	}
	
	/**
	 * 
	 * Add a new GameRule
	 * 
	 * @param rule
	 */
	public void addRule(GameRule rule) {
		rules.add(rule);
	}

	/**
	 * 
	 * Remove a GameRule
	 * 
	 * @param rule
	 */
	public void removeRule(GameRule rule) {
		rules.remove(rule);
	}
	
	/**
	 * 	
	 * @return A List with all registered GameRules
	 */
	public List<GameRule> getRules() {
		return rules;
	}
	
	/**
	 * 
	 * Start a GameInstance
	 * 
	 * @param id The ID of the GameInstance
	 * @param instance The Instance
	 * @return The success of the Game Start
	 */
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
	
	/**
	 * 
	 * Stop a GameInstance
	 * 
	 * @param id The ID of the GameInstance
	 */
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
