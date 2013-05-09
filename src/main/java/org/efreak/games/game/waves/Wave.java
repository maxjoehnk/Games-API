package org.efreak.games.game.waves;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class Wave {

	private Location spawnPoint;
	private List<EntityType> mobs;
	
	public Wave(int waveStrength, Location spawnPoint) {
		mobs = new ArrayList<EntityType>();
		//TODO: Add random mob generation based on point system
		this.spawnPoint = spawnPoint;
	}
	
	public Wave(List<EntityType> mobs, Location spawnPoint) {
		this.mobs = mobs;
		this.spawnPoint = spawnPoint;
	}
	
	public void spawn() {
		for (EntityType entity : mobs) spawnPoint.getWorld().spawnEntity(spawnPoint, entity);
	}
	
}
