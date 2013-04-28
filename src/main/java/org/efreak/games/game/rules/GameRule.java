package org.efreak.games.game.rules;

import org.efreak.games.game.GameInstance;
import org.efreak.games.game.actions.GameAction;

public interface GameRule {

	public boolean isValid(GameInstance instance);
	public boolean isActionValid(GameInstance instance, GameAction action);
	
}
