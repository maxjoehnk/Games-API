package org.efreak.games.game.actions;

import org.bukkit.Location;
import org.efreak.games.GamePlayer;

public class PlayerSpawnAction implements PlayerAction {

	private GamePlayer player;
	private Location spawnPoint;
	
	public PlayerSpawnAction(GamePlayer player, Location spawnPoint) {
		this.player = player;
		this.spawnPoint = spawnPoint;
	}

	@Override
	public GamePlayer getPlayer() {
		return player;
	}
	
	public Location getSpawnPoint() {
		return spawnPoint;
	}
}
