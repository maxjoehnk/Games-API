package org.efreak.games.game.rules;

import java.util.List;

import org.efreak.games.GamePlayer;
import org.efreak.games.game.GameInstance;
import org.efreak.games.game.PlayerClass;
import org.efreak.games.game.actions.ClassPickAction;
import org.efreak.games.game.actions.GameAction;

public class ClassRule extends GameRule {

	private List<PlayerClass> classes;
	
	public ClassRule(List<PlayerClass> allowedClasses) {
		super("ClassRule");
		classes = allowedClasses;
	}
	
	@Override
	public boolean isValid(GameInstance instance) {
		for (GamePlayer player : instance.getPlayers()) {
			if (player.getPlayerClass() == null) return false;
			if (!classes.contains(player.getPlayerClass())) return false;
		}
		return true;
	}

	@Override
	public boolean isActionValid(GameInstance instance, GameAction action) {
		if (action instanceof ClassPickAction) return classes.contains(((ClassPickAction) action).getPlayerClass());
		return true;
	}
}
