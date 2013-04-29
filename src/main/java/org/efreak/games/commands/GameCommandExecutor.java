package org.efreak.games.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import org.efreak.games.GameManager;
import org.efreak.games.Games;
import org.efreak.games.IOManager;
import org.efreak.games.game.Game;

public class GameCommandExecutor implements CommandExecutor {

	private static final IOManager io;
	
	static {
		io = Games.getIOManager();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = null;
		ConsoleCommandSender c = null;
		if (sender instanceof Player) p = (Player) sender;
		if (sender instanceof ConsoleCommandSender) c = (ConsoleCommandSender) sender;
		if (p == c) return false;
		if (label.equalsIgnoreCase("games")) {
			for (Game game : GameManager.getGameList()) io.send(sender, game.getName() + ": " + game.getDesc());
			return true;
		}else if (label.equalsIgnoreCase("game")) {
			
			return true;
		}
		return false;
	}
}
