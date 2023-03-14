package maxetkita.bedwars.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import maxetkita.bedwars.Bedwars;

public class Locations {
	
	public static List<Location> getSpawnLocs(FileConfiguration config, Bedwars main) { //Permet de creer une liste des locations des generateur de chaques teams

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
	
	public static Location getSpawnLocation(String team, FileConfiguration config, Bedwars main) {
		
		List<Location> locs = new ArrayList<>(Locations.getSpawnLocs(config, main));
		Location spawn;
		
		switch(team) {
		case "red":
			spawn = locs.get(0);
			break;
		case "blue":
			spawn = locs.get(1);
			break;
		case "green":
			spawn = locs.get(2);
			break;
		case "yellow":
			spawn = locs.get(3);
			break;
		default: return null;
		}
		
		return spawn;
	}
	
}
