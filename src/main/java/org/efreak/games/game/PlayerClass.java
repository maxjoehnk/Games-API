package org.efreak.games.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.efreak.games.Configuration;
import org.efreak.games.Games;

public class PlayerClass {

	private static final Configuration config;
	private List<PotionEffect> effects;
	private List<ItemStack> items;
	private List<ItemStack> armor;
	private ItemStack defaultEquiped = null;
	
	static {
		config = Games.getConfiguration();
	}
	
	public PlayerClass(String configPath) {
		effects = new ArrayList<PotionEffect>();
		items = new ArrayList<ItemStack>();
		armor = new ArrayList<ItemStack>();
		if (config.contains(configPath + ".Items")) {
			List<Integer> itemIds = config.getIntegerList(configPath + ".Items");
			for (int id : itemIds) items.add(new ItemStack(id));
		}
		if (config.contains(configPath + ".Armor")) {
			List<Integer> armorIds = config.getIntegerList(configPath + ".Armor");
			for (int id : armorIds) armor.add(new ItemStack(id));
		}
		if (config.contains(configPath + ".DefaultEquiped")) 
			defaultEquiped = new ItemStack(config.getInt(configPath + ".DefaultEquiped"));
		if (config.contains(configPath + ".Effects")) {
			List<String> effectList = config.getStringList(configPath + ".Effects");
			for (String effectOptions : effectList) {
				String[] options = effectOptions.split(":");
				PotionEffectType effectType = PotionEffectType.getByName(options[0].toUpperCase());
				PotionEffect potionEffect;
				if (options.length == 2) {
					try {
						potionEffect = new PotionEffect(effectType, 2147483647, Integer.valueOf(options[1]));
					}catch(NumberFormatException e) {
						potionEffect = new PotionEffect(effectType, 2147483647, 1);
					}
				}else potionEffect = new PotionEffect(effectType, 2147483647, 1);
				effects.add(potionEffect);
			}
		}
	}
	
	public void equip(Player player) {
		Collection<PotionEffect> oldEffects = player.getActivePotionEffects();
		for (PotionEffect effect : oldEffects) player.removePotionEffect(effect.getType());
		PlayerInventory inv = player.getInventory();
		inv.clear();
		for (ItemStack item : items) inv.addItem(item);
		inv.setArmorContents(armor.toArray(new ItemStack[4]));
		if (defaultEquiped != null) player.setItemInHand(defaultEquiped);
	    player.addPotionEffects(effects);
	}
}
