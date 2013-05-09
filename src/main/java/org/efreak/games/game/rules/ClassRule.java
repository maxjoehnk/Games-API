package org.efreak.games.game.rules;

import java.util.List;

import org.efreak.games.game.GameInstance;
import org.efreak.games.game.PlayerClass;
import org.efreak.games.game.actions.GameAction;

public class ClassRule implements GameRule {

	List<PlayerClass> classes;
	
	public ClassRule(List<PlayerClass> allowedClasses) {
		classes = allowedClasses;
	}
	
	@Override
	public boolean isValid(GameInstance instance) {
		return false;
	}

	@Override
	public boolean isActionValid(GameInstance instance, GameAction action) {
		return false;
	}
}
