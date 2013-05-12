package org.efreak.games.game.rules;

import org.efreak.games.game.GameInstance;
import org.efreak.games.game.actions.GameAction;

public class WaveRule extends GameRule {

	public WaveRule() {
		super("WaveRule");
	}

	@Override
	public boolean isValid(GameInstance instance) {
		return true;
	}

	@Override
	public boolean isActionValid(GameInstance instance, GameAction action) {
		return true;
	}

}
