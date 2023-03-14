package maxetkita.bedwars.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import maxetkita.bedwars.Bedwars;
import maxetkita.bedwars.utils.Locations;

public class PlayerBlocksManager implements Listener{
	
	private static Bedwars main;
	private static FileConfiguration config;
	public PlayerBlocksManager(Bedwars main) {
		PlayerBlocksManager.main = main;
		config = PresetManager.getPreset(main);
	}
/*Controle placement/destruction des blocks par les joueurs
*
* Creer un listener pr les blocks placés : check si ils sont pas ds la zone de spawn-protection (config) + si ils sont pas au dessus de la couche max (config)
* 
* Creer un listener pr les blocks cassés (mm chose)
* 
* Check si les explosions + creation de bridges (Bridge Eggs) n'abiment pas la zone de spawn-protection
*/
	
	@EventHandler
	public static void placeBlock(BlockPlaceEvent e) { //A TESTER
		Player p = e.getPlayer();
		String team = TeamsManager.getPlayerTeam(main.getConfig(), p);
		if(team.equals("none")) return;
		
		Location lb = e.getBlock().getLocation();
		List<Location> locs = new ArrayList<>(Locations.getSpawnLocs(config, main));
		Location iloc;
		switch(team) {
		case "red":
			iloc = locs.get(0);
			break;
		case "blue":
			iloc = locs.get(1);
			break;
		case "green":
			iloc = locs.get(2);
			break;
		case "yellow":
			iloc = locs.get(3);
			break;
		default: return;
		}
		double protection = config.getDouble("iron-gen.spawn-protection");
		if(lb.distance(iloc) <= protection) {
			e.setCancelled(true);
		}
		
		double minY = config.getDouble("map.minY");
		double maxY = config.getDouble("map.maxY");
		if(lb.getY() <= minY) {
			e.setCancelled(true);
		}
		if(lb.getY() >= maxY) {
			e.setCancelled(true);
		}
	}
	
	
}
