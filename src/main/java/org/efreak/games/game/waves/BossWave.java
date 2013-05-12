package org.efreak.games.game.waves;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class BossWave extends Wave {

	public BossWave(List<EntityType> mobs, Location spawnPoint) {
		super(mobs, spawnPoint);
	}
}
