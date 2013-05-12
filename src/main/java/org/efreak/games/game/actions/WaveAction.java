package org.efreak.games.game.actions;

import org.efreak.games.game.waves.Wave;

public interface WaveAction extends GameAction {

	public Wave getWave();
	public boolean isBossWave();
}
