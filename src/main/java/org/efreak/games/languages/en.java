package org.efreak.games.languages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.efreak.games.Games;

public class en extends Language {
	
	@Override
	public void createLanguageFile() {
		langFile = new File(Games.getInstance().getDataFolder(), "lang/en.lang");
		if (!langFile.exists()) {
			try {
				langFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateLanguage() {
		lang = new YamlConfiguration();
		try {
			lang.load(langFile);
			
			set("Plugin.Done", "&aDone!");
			set("Plugin.LoadingCommands", "&2Loading Commands...");
			set("Plugin.CommandsLoaded", "&aCommands successfully loaded!");
			set("Plugin.Debug", "Games API runs in Debug Mode");
			
			set("Permissions.ForceSuper", "&2Superperms forced!");
			set("Permissions.Found", "&a%perms% support enabled!");
			set("Permissions.NoPerms", "&eNo Permissions System Found!");
			set("Permissions.OP", "&aUsing OP-Rights for Commands!");

			set("Command.FewArgs", "&cToo few Arguments");
			set("Command.ManyArgs", "&cToo many Arguments");
			set("Command.Usage", "Usage: %usage%");
			set("Command.NoPerm.Player", "&cYou dont have Permission to do that!");
			set("Command.NoPerm.Console", "&e%player% has tried to perform command &8%cmd%!");
			set("Command.Language.Get", "The Language is %lang%.");
			set("Command.Language.Set", "&aThe Language was set to %lang%!");
			set("Command.Language.Error", "&cThe Language %lang% doesn't exists!");
			save();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
}
