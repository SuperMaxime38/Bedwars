package maxetkita.bedwars.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class TeamsManager {
	
	public static List<String> getFullTeams(FileConfiguration config) { //Get all the full teams
		List<String> red = new ArrayList<String>();
		List<String> blue = new ArrayList<String>();
		List<String> green = new ArrayList<String>();
		List<String> yellow = new ArrayList<String>();
		
		List<String> teams = new ArrayList<String>();
		
		red = config.getStringList("team.red.players");
		blue = config.getStringList("team.blue.players");
		green = config.getStringList("team.green.players");
		yellow = config.getStringList("team.yellow.players");
		
		int maxplayers = config.getInt("team.maxplayers");
		
		if(red.size() == maxplayers) teams.add("red");
		if(blue.size() == maxplayers) teams.add("blue");
		if(green.size() == maxplayers) teams.add("green");
		if(yellow.size() == maxplayers) teams.add("yellow");
		
		return teams;
	}
	
	
	public static List<String> getNonFullTeams(FileConfiguration config) { //Get all the empty and non-full teams
		List<String> red = new ArrayList<String>();
		List<String> blue = new ArrayList<String>();
		List<String> green = new ArrayList<String>();
		List<String> yellow = new ArrayList<String>();
		
		List<String> teams = new ArrayList<String>();
		
		red = config.getStringList("team.red.players");
		blue = config.getStringList("team.blue.players");
		green = config.getStringList("team.green.players");
		yellow = config.getStringList("team.yellow.players");
		
		int maxplayers = config.getInt("team.maxplayers");
		
		if(red.size() < maxplayers) teams.add("red");
		if(blue.size() < maxplayers) teams.add("blue");
		if(green.size() < maxplayers) teams.add("green");
		if(yellow.size() < maxplayers) teams.add("yellow");
		
		return teams;
	}
	
	public static List<String> getEmptyTeams(FileConfiguration config) { //get all the empty teams
		List<String> red = new ArrayList<String>();
		List<String> blue = new ArrayList<String>();
		List<String> green = new ArrayList<String>();
		List<String> yellow = new ArrayList<String>();
		
		List<String> teams = new ArrayList<String>();
		
		red = config.getStringList("team.red.players");
		blue = config.getStringList("team.blue.players");
		green = config.getStringList("team.green.players");
		yellow = config.getStringList("team.yellow.players");
		
		if(red.size() == 0) teams.add("red");
		if(blue.size() == 0) teams.add("blue");
		if(green.size() == 0) teams.add("green");
		if(yellow.size() == 0) teams.add("yellow");
		
		return teams;
	}
	
	public static String getPlayerTeam(FileConfiguration config, Player p) { //Get the team of a player
		String name = p.getDisplayName();
		String team;
		
		List<String> red = new ArrayList<String>();
		List<String> blue = new ArrayList<String>();
		List<String> green = new ArrayList<String>();
		List<String> yellow = new ArrayList<String>();
		
		red = config.getStringList("team.red.players");
		blue = config.getStringList("team.blue.players");
		green = config.getStringList("team.green.players");
		yellow = config.getStringList("team.yellow.players");
		
		if(red.contains(name)) {
			team = "red";
		}else if(blue.contains(name)) {
			team = "blue";
		}else if(green.contains(name)) {
			team = "green";	
		}else if(yellow.contains(name)) {
			team = "yellow";
		} else {
			team = "none";
		}
		
		return team;
		
	}
	
	public static List<String> getTeam(FileConfiguration config, String team) {
		
		List<String> red = new ArrayList<String>();
		List<String> blue = new ArrayList<String>();
		List<String> green = new ArrayList<String>();
		List<String> yellow = new ArrayList<String>();
		
		red = config.getStringList("team.red.players");
		blue = config.getStringList("team.blue.players");
		green = config.getStringList("team.green.players");
		yellow = config.getStringList("team.yellow.players");
		
		if(team == "red") return red;
		if(team == "blue") return blue;
		if(team == "green") return green;
		if(team == "yellow") return yellow;
		return null;
	}
	
	public static ChatColor getPlayerTeamColor(FileConfiguration config, Player p) {
		String team = getPlayerTeam(config, p);
		switch(team) {
		case "red":
			return ChatColor.RED;
		case "blue":
			return ChatColor.BLUE;
		case "green":
			return ChatColor.GREEN;
		case "yellow":
			return ChatColor.YELLOW;
		case "none":
			return ChatColor.WHITE;
		default:
			return ChatColor.WHITE;
		}
	}
	
}
