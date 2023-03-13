package maxetkita.bedwars.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import maxetkita.bedwars.Bedwars;

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
		List<Location> locs = new ArrayList<>(getSpawnLocs(config));
		double protection = config.getDouble("iron-gen.spawn-protection");
		if(lb.distance(locs.get(0)) <= protection) {
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
	
	public static List<Location> getSpawnLocs(FileConfiguration config) {

		int Rx = main.getConfig().getInt("iron-gen.red.locX");
		int Ry = main.getConfig().getInt("iron-gen.red.locY");
		int Rz = main.getConfig().getInt("iron-gen.red.locZ");
		
		int Bx = main.getConfig().getInt("iron-gen.blue.locX");
		int By = main.getConfig().getInt("iron-gen.blue.locY");
		int Bz = main.getConfig().getInt("iron-gen.blue.locZ");
		
		int Gx = main.getConfig().getInt("iron-gen.green.locX");
		int Gy = main.getConfig().getInt("iron-gen.green.locY");
		int Gz = main.getConfig().getInt("iron-gen.green.locZ");
		
		int Yx = main.getConfig().getInt("iron-gen.yellow.locX");
		int Yy = main.getConfig().getInt("iron-gen.yellow.locY");
		int Yz = main.getConfig().getInt("iron-gen.yellow.locZ");
		
		Location red = new Location(Bukkit.getWorld("world"), Rx, Ry, Rz);
		Location blue = new Location(Bukkit.getWorld("world"), Bx, By, Bz);
		Location green = new Location(Bukkit.getWorld("world"), Gx, Gy, Gz);
		Location yellow = new Location(Bukkit.getWorld("world"), Yx, Yy, Yz);
		
		List<Location> locs = new ArrayList<>();
		locs.add(red);
		locs.add(blue);
		locs.add(green);
		locs.add(yellow);
		
		return locs;
	}
}
