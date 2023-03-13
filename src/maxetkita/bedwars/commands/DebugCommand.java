package maxetkita.bedwars.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;

import maxetkita.bedwars.Bedwars;
import maxetkita.bedwars.managers.IngotGenerator;
import maxetkita.bedwars.managers.LanguagesManager;
import maxetkita.bedwars.managers.MapGenerator;
import maxetkita.bedwars.managers.PresetManager;
import maxetkita.bedwars.managers.TeamsManager;
import maxetkita.bedwars.shop.IronNPC;

public class DebugCommand implements CommandExecutor{

	private Bedwars main;
	public DebugCommand(Bedwars main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		FileConfiguration config = PresetManager.getPreset(main);
		FileConfiguration lang = LanguagesManager.getLang(main);
		
		if(args.length == 0) {
			
		} else if(args.length == 1) {
			switch(args[0]) {
			case "activate":
				main.getConfig().set("enable", true);
				main.saveConfig();
				IngotGenerator.generateAll(main);
				return true;
			case "disable":
				main.getConfig().set("enable", false);
				main.saveConfig();
				return true;
			case "spawnvillager":
				IronNPC.spawnIronNPC(main);
				return true;
			case "killvillager":
				for (Entity entity : Bukkit.getWorld("world").getLivingEntities()) {
					if(entity.getCustomName() != null && entity.getCustomName().contains("Iron Shop")) {
						entity.remove();
					}
				}
				return true;
			case "lang":
				sender.sendMessage(lang.getString("commands").toString());
				//LangEN.get().get("commands");
				return true;
			case "genmap":
				MapGenerator.genMap(main);
				return true;
			}
		} else if(args.length == 2) {
			switch(args[0]) {
			case "getlist":
				List<String> team = new ArrayList<String>();
				switch(args[1]) {
				case "red":
					team = TeamsManager.getTeam(config, "red");
					sender.sendMessage("Items in list red : " + team.toString());
					return true;
				case "blue":
					team = TeamsManager.getTeam(config, "blue");
					sender.sendMessage("Items in list blue : " + team.toString());
					return true;
				case "green":
					team = TeamsManager.getTeam(config, "green");
					sender.sendMessage("Items in list green : " + team.toString());
					return true;
				case "yellow":
					team = TeamsManager.getTeam(config, "yellow");
					sender.sendMessage("Items in list yellow : " + team.toString());
					return true;
				}
			case "newpreset":
				PresetManager.fileCheck(args[1], main);
				return true;
				
			case "langs":
				switch(args[1]) {
				case "en":
					main.getConfig().set("lang", "en_us");
					main.saveConfig();
					sender.sendMessage("[Lang] > Language changed on English");
					break;
				case "fr":
					main.getConfig().set("lang", "fr_fr");
					main.saveConfig();
					sender.sendMessage("[Lang] > Language changed on French");
					break;
				}
				return true;
			}
		}
		return false;
	}

}
