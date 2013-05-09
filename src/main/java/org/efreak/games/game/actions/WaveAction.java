package org.efreak.games.game.actions;

import org.efreak.games.game.waves.Wave;

public class WaveAction implements GameAction {

	private Wave wave;
	
	public WaveAction(Wave wave) {
		this.wave = wave;
	}
	
}
