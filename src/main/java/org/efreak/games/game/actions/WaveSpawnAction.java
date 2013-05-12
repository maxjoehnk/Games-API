package org.efreak.games.game.actions;

import org.efreak.games.game.waves.Wave;

public class WaveSpawnAction implements WaveAction {

	private Wave wave;
	private boolean bossWave;
	
	public WaveSpawnAction(Wave wave) {
		this.wave = wave;
		bossWave = false;
	}
	
	public WaveSpawnAction(Wave wave, boolean bossWave) {
		this.wave = wave;
		this.bossWave = bossWave;
	}
	
	@Override
	public Wave getWave() {
		return wave;
	}

	@Override
	public boolean isBossWave() {
		return bossWave;
	}

}
