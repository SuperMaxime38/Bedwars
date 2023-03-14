package maxetkita.bedwars.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import maxetkita.bedwars.Bedwars;

public class BedBrokenManager implements Listener{
	
	private static Bedwars main;
	public BedBrokenManager(Bedwars main) {
		BedBrokenManager.main = main;
	}
	
	@EventHandler
	public static void bedBroken(BlockBreakEvent e) {
		Player p = e.getPlayer();
		String team = TeamsManager.getPlayerTeam(main.getConfig(), p);
		if(team.equals("none")) return;
		Block b = e.getBlock();
		if(b.getType().equals(Material.RED_BED)) {
			Location red = getRedBedLoc();
			Location blue = getBlueBedLoc();
			Location green = getGreenBedLoc();
			Location yellow = getYellowBedLoc();
			
			Location bloc = b.getLocation();
			
			List<String> members = new ArrayList<String>();
			Player pl;
			
			if(bloc.distance(red) <= 1) {
				if(team.equals("red")) {
					e.setCancelled(true);
					return;
				}
				main.getConfig().set("bed.red.alive", false);
				main.saveConfig();
				members = TeamsManager.getTeam(main.getConfig(), "red");
				for(int i = 1; i <= members.size(); i++) {
					pl = Bukkit.getPlayer(members.get(i));
					pl.sendTitle("§4Your bed was destroyed", "You will not longer respawn", 1, 40, 5); //Penser a creer une traduction
				}
				return;
			} else if(bloc.distance(blue) <= 1) {
				if(team.equals("blue")) {
					e.setCancelled(true);
					return;
				}
				main.getConfig().set("bed.blue.alive", false);
				main.saveConfig();
				members = TeamsManager.getTeam(main.getConfig(), "blue");
				for(int i = 0; i <= members.size(); i++) {
					pl = Bukkit.getPlayer(members.get(i));
					pl.sendTitle("§4Your bed was destroyed", "You will not longer respawn", 1, 40, 5);
				}
				return;
				
			} else if(bloc.distance(green) <= 1) {
				if(team.equals("green")) {
					e.setCancelled(true);
					return;
				}
				main.getConfig().set("bed.green.alive", false);
				main.saveConfig();
				members = TeamsManager.getTeam(main.getConfig(), "green");
				for(int i = 0; i <= members.size(); i++) {
					pl = Bukkit.getPlayer(members.get(i));
					pl.sendTitle("§4Your bed was destroyed", "You will not longer respawn", 1, 40, 5);
				}
				return;
				
			} else if(bloc.distance(yellow) <= 1) {
				if(team.equals("yellow")) {
					e.setCancelled(true);
					return;
				}
				main.getConfig().set("bed.yellow.alive", false);
				main.saveConfig();
				members = TeamsManager.getTeam(main.getConfig(), "yellow");
				for(int i = 0; i <= members.size(); i++) {
					pl = Bukkit.getPlayer(members.get(i));
					pl.sendTitle("§4Your bed was destroyed", "You will not longer respawn", 1, 40, 5);
				}
				return;
				
			} else {
				e.setCancelled(true);
				return;
			}
			
		} else {
			return;
		}
		
	}
	
	public static Location getRedBedLoc() {
		double X = main.getConfig().getDouble("bed.red.X");
		double Y = main.getConfig().getDouble("bed.red.Y");
		double Z = main.getConfig().getDouble("bed.red.Z");
		Location loc = new Location(Bukkit.getWorld("world"), X, Y, Z);
		return loc;
	}
	public static Location getBlueBedLoc() {
		double X = main.getConfig().getDouble("bed.blue.X");
		double Y = main.getConfig().getDouble("bed.blue.Y");
		double Z = main.getConfig().getDouble("bed.blue.Z");
		Location loc = new Location(Bukkit.getWorld("world"), X, Y, Z);
		return loc;
	}
	public static Location getGreenBedLoc() {
		double X = main.getConfig().getDouble("bed.green.X");
		double Y = main.getConfig().getDouble("bed.green.Y");
		double Z = main.getConfig().getDouble("bed.green.Z");
		Location loc = new Location(Bukkit.getWorld("world"), X, Y, Z);
		return loc;
	}
	public static Location getYellowBedLoc() {
		double X = main.getConfig().getDouble("bed.yellow.X");
		double Y = main.getConfig().getDouble("bed.yellow.Y");
		double Z = main.getConfig().getDouble("bed.yellow.Z");
		Location loc = new Location(Bukkit.getWorld("world"), X, Y, Z);
		return loc;
	}
}
