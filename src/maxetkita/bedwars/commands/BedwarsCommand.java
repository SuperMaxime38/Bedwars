package maxetkita.bedwars.commands;

import java.io.File;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import maxetkita.bedwars.Bedwars;
import maxetkita.bedwars.managers.IngotGenerator;
import maxetkita.bedwars.managers.LanguagesManager;
import maxetkita.bedwars.managers.PresetManager;
import maxetkita.bedwars.managers.TeamsManager;
import maxetkita.bedwars.utils.LastDamager;

public class BedwarsCommand implements CommandExecutor{

	private Bedwars main;
	FileConfiguration lang;
	String header;
	public BedwarsCommand(Bedwars main) {
		this.main = main;
	}
	
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		
		lang = LanguagesManager.getLang(main);
		
		if(s instanceof Player) {
			String getheader = main.getConfig().getString("custom-broadcast");
			header = ChatColor.translateAlternateColorCodes('&', getheader);
		} else {
			header = ChatColor.GOLD + "[Baidouars] >" + ChatColor.WHITE;
		}
		
		if(args.length == 0) {
			s.sendMessage(header + lang.getString("commands.bedwars.noargs"));
			return true;
		} else if(args.length == 1) {
			switch(args[0]) {
			case "preset":
				s.sendMessage(header + lang.getString("commands.bedwars.preset.noargs"));
				s.sendMessage(header + lang.getString("commands.bedwars.preset.cmdlist"));
				return true;
			case "start": //Start a game of bedwars
				main.getConfig().set("enable", true);
				main.saveDefaultConfig();
				List<String> players = TeamsManager.getAllPlayers(main.getConfig());
				LastDamager.init(players);
				IngotGenerator.generateAll(main);
				s.sendMessage(lang.getString("commands.bedwars.start"));
				return true;
			case "lang":
				s.sendMessage(header + lang.getString("commands.lang.noargs"));
				s.sendMessage(header + lang.getString("commands.lang.noargs2"));
				return true;
			}
		} else if(args.length == 2) {
			switch(args[0]) {
			case "preset":
				if(args[1].equals("enable")) {
					main.getConfig().set("preset.enable", true);
					main.saveDefaultConfig();
					s.sendMessage(header + lang.getString("commands.bedwars.preset.enable"));
					
				} else if(args[1].equals("disable")) {
					main.getConfig().set("preset.enable", false);
					main.saveDefaultConfig();
					s.sendMessage(header + lang.getString("commands.bedwars.preset.disable"));
				} else if(args[1].equals("list")) {
					File dir  = new File(Bukkit.getServer().getPluginManager().getPlugin("Baidouars").getDataFolder(), File.separator + "presets");
				      File[] liste = dir.listFiles();
				      if(liste.length == 0) {
				    	  s.sendMessage(header  + lang.getString("commands.bedwars.preset.nopresets"));
				      } else {
				    	  s.sendMessage(header  + lang.getString("commands.bedwars.preset.list"));
				      }
				      
				      for(File item : liste){
				        if(item.isFile())
				        { 
				        	s.sendMessage("- " + item.getName());
				        }
				      }
				} else if(args[1].equals("current")) {
					
					String current = main.getConfig().getString("preset.name");
					if(main.getConfig().getBoolean("preset.enable") == true) {
						s.sendMessage(header + lang.getString("commands.bedwars.preset.current") + current);
					} else {
						s.sendMessage(header + lang.getString("commands.bedwars.preset.currentdis") + current);
					}
				}else {
					s.sendMessage(header + lang.getString("commands.bedwars.preset.invalid"));
					s.sendMessage(header + lang.getString("commands.bedwars.preset.cmdlist"));
					
				}
				return true;
			case "lang":
				switch(args[1]) {
				case "en_us":
					main.getConfig().set("lang", "en_us");
					main.saveDefaultConfig();
					lang = LanguagesManager.getLang(main);
					s.sendMessage(header + lang.getString("commands.lang.changed"));
					break;
				case "fr_fr":
					main.getConfig().set("lang", "fr_fr");
					main.saveDefaultConfig();
					lang = LanguagesManager.getLang(main);
					s.sendMessage(header + lang.getString("commands.lang.changed"));
					break;
				default:
					s.sendMessage(header + lang.getString("commands.lang.error"));
					break;
				}
				return true;
			}
		} else if(args.length == 3) {
			switch(args[0]) {
			case "preset":
				boolean exist = PresetManager.doesExist(args[2]);
				switch(args[1]) {
				case "create":
					if(exist == true) {
						s.sendMessage(header + lang.getString("commands.bedwars.preset.create"));
					} else {
						PresetManager.fileCheck(args[2], main);
						s.sendMessage(header + "§aThe file " + args[2] + ".yml has been created");
					}
					break;
				case "load":
					if(exist == true) {
						main.getConfig().set("preset.name", args[2]);
						main.saveDefaultConfig();
						s.sendMessage(header + "§aThe preset " + args[2] + " succesfully loaded");
					} else {
						s.sendMessage(header + lang.getString("commands.bedwars.preset.doesntexist"));
					}
					break;
				case "delete":
					if(exist == true) {
						s.sendMessage(header  + lang.getString("commands.bedwars.preset.delete") + args[2]);
					} else {
						s.sendMessage(header  + lang.getString("commands.bedwars.preset.doesntexist"));
					}
					break;
				case "deleteconfirm":
					if(exist == true) {
						if(args[2].equals(main.getConfig().getString("preset.name"))) {
							main.getConfig().set("preset.name", "null");
							main.saveDefaultConfig();
							s.sendMessage(header + lang.getString("commands.bedwars.preset.deleteconfirm"));
						}
						File dir  = new File(Bukkit.getServer().getPluginManager().getPlugin("Baidouars").getDataFolder(), File.separator + "presets");
						File f = new File(dir, File.separator + args[2] + ".yml");
						if(f.exists()) {
							f.delete();
							s.sendMessage(header + "§aThe preset " + args[2] + " has been succesfully deleted");
						}
					} else {
						s.sendMessage(header + lang.getString("commands.bedwars.preset.doesntexist"));
					}
					break;
				}
				return true;
			}
		} else {
			
		}
		
		return false;
	}

}
