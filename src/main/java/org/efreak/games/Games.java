package org.efreak.games;

import org.bukkit.plugin.java.JavaPlugin;

public class Games extends JavaPlugin {

	private static JavaPlugin instance;
	
	@Override
	public void onLoad() {
		instance = this;
	}
	
	@Override
	public void onEnable() {
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static JavaPlugin getInstance() {
		return instance;
	}
	
}
