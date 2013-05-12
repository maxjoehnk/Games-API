package org.efreak.games.game.rules;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class RulesList implements Iterable<GameRule> {

	private List<GameRule> rules;
	private HashMap<String, GameRule> rulesMap;
	
	public void addAll(RulesList rules) {
		
	}
	
	public void add(GameRule rule) {
		rules.add(rule);
		rulesMap.put(rule.getName(), rule);
	}
	
	public void add(GameRule rule, String name) {
		rules.add(rule);
		rulesMap.put(name, rule);
	}
	
	public GameRule get(int index) {
		return rules.get(index);
	}
	
	public GameRule get(String name) {
		return rulesMap.get(name);
	}
	
	public void replace(GameRule rule) {
		rules.remove(rulesMap.get(rule.getName()));
		rulesMap.remove(rule.getName());
		rules.add(rule);
		rulesMap.put(rule.getName(), rule);
	}
	
	public void remove(GameRule rule) {
		rules.remove(rule);
		rulesMap.remove(rule.getName());
	}
	
	public void remove(GameRule rule, String name) {
		rules.remove(rule);
		rulesMap.remove(name);
	}
	
	public List<GameRule> getList() {
		return rules;
	}
	
	public HashMap<String, GameRule> getMap() {
		return rulesMap;
	}

	@Override
	public Iterator<GameRule> iterator() {
		return rules.iterator();
	}
	
}
