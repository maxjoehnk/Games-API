package org.efreak.games.game.rules;

import org.efreak.games.game.GameInstance;
import org.efreak.games.game.actions.GameAction;

public abstract class GameRule {
		
	protected final String name;
	
	public GameRule(String name) {
		this.name = name;
	}
	
	public abstract boolean isValid(GameInstance instance);
	public abstract boolean isActionValid(GameInstance instance, GameAction action);
	
	public String getName() {
		return name;
	}
}
