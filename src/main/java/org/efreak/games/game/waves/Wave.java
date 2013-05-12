package org.efreak.games.game.waves;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;

public class Wave {

	private Location spawnPoint;
	private List<EntityType> mobs;
	
	public Wave(List<EntityType> mobs, Location spawnPoint) {
		this.mobs = mobs;
		this.spawnPoint = spawnPoint;
	}

	public void spawn() {
		for (EntityType entity : mobs) spawnPoint.getWorld().spawnEntity(spawnPoint, entity);
	}
	
	public static Wave createWave(ConfigurationSection path, ConfigurationSection spawnPath) {
		Location location = new Location(Bukkit.getWorld(spawnPath.getString("WaveSpawn.World")), spawnPath.getDouble("WaveSpawn.X"), spawnPath.getDouble("WaveSpawn.Y"), spawnPath.getDouble("WaveSpawn.Z"));
		return createWave(path, location);
	}
	
	public static Wave createWave(ConfigurationSection path, Location location) {
		WaveType type = WaveType.valueOf(path.getString("Type"));
		List<EntityType> mobs = new ArrayList<EntityType>();
		switch (type) {
			case RANDOM:
				
				//TODO: Add random mob generation based on point system
				return new Wave(mobs, location);
			case SET:
				for (String mob : path.getConfigurationSection("Mobs").getKeys(false)) {
					if (EntityType.valueOf(mob.toUpperCase()) == null) continue;
					int amount = path.getInt("Mobs." + mob);
					for (int i = 0; i < amount; i++) mobs.add(EntityType.valueOf(mob.toUpperCase()));
				}
				return new Wave(mobs, location);
		}
		return null;
	}
	
}
