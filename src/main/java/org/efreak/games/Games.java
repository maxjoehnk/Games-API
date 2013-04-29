package org.efreak.games;

import org.bukkit.plugin.java.JavaPlugin;

import org.efreak.games.commands.GameCommandExecutor;
import org.efreak.games.databases.MySQL;
import org.efreak.games.databases.SQLite;

public class Games extends JavaPlugin {

	private static JavaPlugin instance;
	private static Configuration config;
	private static IOManager io;
	private static Database db;
	
	@Override
	public void onLoad() {
		instance = this;
	}
	
	@Override
	public void onEnable() {
		getDataFolder().mkdir();
		config = new Configuration();
		io = new IOManager();
		config.init();
		io.init();
		if (config.getDebug()) io.sendConsoleWarning(io.translate("Plugin.Debug"));
		Database.registerDatabaseSystem("MySQL", new MySQL());
		Database.registerDatabaseSystem("SQLite", new SQLite());
		db = Database.getDatabaseBySystem(config.getString("Database.System"));
		if (db == null) {
			io.sendConsoleWarning("Unknown Database System. Falling back to SQLite");
			db = Database.getDatabaseBySystem("SQLite");
		}
		db.init();
		getServer().getPluginCommand("game").setExecutor(new GameCommandExecutor());
		getServer().getPluginCommand("games").setExecutor(new GameCommandExecutor());
	}
	
	@Override
	public void onDisable() {
    	db.shutdown();
	}
	
	public static JavaPlugin getInstance() {
		return instance;
	}
	
	public static Configuration getConfiguration() {
		return config;
	}
	
	public static IOManager getIOManager() {
		return io;
	}
	
	public static Database getDb() {
		return db;
	}
}
