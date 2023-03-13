package maxetkita.bedwars.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import maxetkita.bedwars.Bedwars;
import maxetkita.bedwars.managers.PresetManager;
import maxetkita.bedwars.managers.TeamsManager;

public class BWTeamCommand implements CommandExecutor{

	private Bedwars main;
	public BWTeamCommand(Bedwars main) {
		this.main = main;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§4Only players can do this command");
			return true;
		}
		
		FileConfiguration config = PresetManager.getPreset(main);
		
		Player p = (Player) sender;
		String getheader = main.getConfig().getString("custom-broadcast");
		String header = ChatColor.translateAlternateColorCodes('&', getheader);
		
		if(args.length == 0) {
			p.sendMessage(header + "Liste des commandes pour §8/bwteam §f : ");
			p.sendMessage(header + "§6/bwteam join §f<team>");
			p.sendMessage(header + "§6/bwteam leave §f<team>");
		} else if(args.length == 1 ) {
			if(args[0].equals("join")) {
				List<String> teams = TeamsManager.getNonFullTeams(main.getConfig());
				
				p.sendMessage(header + "Vous pouvez rejoindre différentes teams : ");
				p.sendMessage(header + "'§cred§f', '§9blue§f', '§agreen§f', '§eyellow§f' ");
				if(teams.isEmpty()) {
					p.sendMessage(header + "Actuellement, toutes les teams sont pleines");
					return true;
				} else {
					p.sendMessage(header + "Actuellement, les teams libres sont les teams: " + teams.toString());
					return true;
				}
			} else if(args[0].equals("leave")) {
				String team = TeamsManager.getPlayerTeam(main.getConfig(), p);
				switch(team) {
				case "red":
					main.getConfig().getList("team.red.players").remove(p.getDisplayName());
					main.saveConfig();
					p.sendMessage(header + "Vous avez quitte l'equipe §cred");
					return true;
				case "blue":
					main.getConfig().getList("team.blue.players").remove(p.getDisplayName());
					main.saveConfig();
					p.sendMessage(header + "Vous avez quitte l'equipe §9blue");
					return true;
				case "green":
					main.getConfig().getList("team.green.players").remove(p.getDisplayName());
					main.saveConfig();
					p.sendMessage(header + "Vous avez quitte l'equipe §agreen");
					return true;
				case "yellow":
					main.getConfig().getList("team.yellow.players").remove(p.getDisplayName());
					main.saveConfig();
					p.sendMessage(header + "Vous avez quitte l'equipe §eyellow");
					return true;
				case "none":
					p.sendMessage(header + "Vous devez REJOINDRE une team pour pouvoir la quitter...");
					return true;
				}
			} else {
				p.sendMessage(header + "Liste des commandes pour §8/bwteam §f : ");
				p.sendMessage(header + "§6/bwteam join §f<team>");
				p.sendMessage(header + "§6/bwteam leave §f<team>");
				return true;
			}
		} else if(args.length == 2) {
			if(args[0].equals("join")) {
				
				String t = TeamsManager.getPlayerTeam(main.getConfig(), p);
				if(!t.equals("none")) {
					p.sendMessage(header + "Vous etes deja dans une team...");
					return true;
				}
				
				List<String> fteams = new ArrayList<String>();
				fteams = TeamsManager.getFullTeams(config);
				
				List<String> players = new ArrayList<String>();
				String name = p.getDisplayName();
				switch(args[1]) {
				case "red":
					if(fteams.contains("red")) {
						p.sendMessage(header + "Cette team est pleine");
						return true;
					} else {
						players = (List<String>) main.getConfig().getList("team.red.players");
						players.add(name);
						main.getConfig().set("team.red.players", players);
						main.saveConfig();
						p.sendMessage(header + "Vous avez rejoint la team §cred");
					}
				return true;
				case "blue":
					if(fteams.contains("blue")) {
						p.sendMessage(header + "Cette team est pleine");
						return true;
					} else {
						players = (List<String>) main.getConfig().getList("team.blue.players");
						players.add(name);
						main.getConfig().set("team.blue.players", players);
						main.saveConfig();
						p.sendMessage(header + "Vous avez rejoint la team §9blue");
					}
					return true;
				case "green":
					if(fteams.contains("green")) {
						p.sendMessage(header + "Cette team est pleine");
						return true;
					} else {
						players = (List<String>) main.getConfig().getList("team.green.players");
						players.add(name);
						main.getConfig().set("team.green.players", players);
						main.saveConfig();
						p.sendMessage(header + "Vous avez rejoint la team §agreen");
					}
					return true;
				case "yellow":
					if(fteams.contains("yellow")) {
						p.sendMessage(header + "Cette team est pleine");
						return true;
					} else {
						players = (List<String>) main.getConfig().getList("team.yellow.players");
						players.add(name);
						main.getConfig().set("team.yellow.players", players);
						main.saveConfig();
						p.sendMessage(header + "Vous avez rejoint la team §eyellow");
					}
					return true;
				default:
					p.sendMessage(header + "§4Nom de team invalide (red, blue, green, yellow)");
					return true;
					
				}
			} else {
				p.sendMessage(header + "La commande est §6/bwteam join <team>");
			}
		}
		
		
		return false;
	}

}
