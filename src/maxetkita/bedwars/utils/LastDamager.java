package maxetkita.bedwars.utils;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LastDamager { //make smth to know who hit the last (event if player dont die because of that)

	
	static HashMap<String, String> players = new HashMap<String, String>(); //Creer ca quand une game commenc
	
	public static void init(List<String> pl) { //initialise
		for(int i = 0; i <= pl.size()-1; i++) {
			players.put(pl.get(i), "none");
		}
	}
	
	public static String getLastDamager(Player v) {
		String p = v.getDisplayName();
		String dmg = players.get(p);
		
		return dmg;
	}
	
	public static void setLastDamager(Player p, Player dmg) {
		String player = p.getDisplayName();
		String damager = dmg.getDisplayName();
		
		players.put(player, damager);
	}
	
	public static void test() {
		Bukkit.broadcastMessage("HashMap : " + players.toString());
	}
}
