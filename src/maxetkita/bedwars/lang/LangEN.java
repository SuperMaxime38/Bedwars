package maxetkita.bedwars.lang;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class LangEN {
	 public static void fileCheck(){
	    	
	     File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Baidouars").getDataFolder(), File.separator + "lang");
	     File f = new File(userdata, File.separator + "en_us.yml");
	     FileConfiguration preset = YamlConfiguration.loadConfiguration(f);
	     
	     if (!f.exists()) {
	         try {
	        	 
	        	 preset.createSection("commands");
	        	 
	        	 preset.set("commands.bedwars.noargs", "§aCommands for §6/bedwars §f:"
	        	 		+ "\n§6/bedwars preset §f: Manage presets"
	        	 		+ "\n§6/bedwars start §f: Start a game of bedwars");
	        	 
	        	 preset.set("commands.bedwars.preset.noargs", "§aCommands for §6/bedwars preset §f:");
	        	 preset.set("commands.bedwars.preset.cmdlist", "§6/bedwars preset create <name> §f: Create a new preset"
		        	 		+ "\n§6/bedwars preset load <name> §f: Load an existing preset"
		        	 		+ "\n§6/bedwars preset delete <name> §f: Delete an existing preset"
		        	 		+ "\n§6/bedwars preset enable §f: Activate presets"
		        	 		+ "\n§6/bedwars preset disable §f: Disable presets and use §aconfig.yml"
		        	 		+ "\n§6/bedwars preset list §f: List all the presets"
		        	 		+ "\n§6/bedwars preset current §f: Display the actual preset");
	        	 
	        	 preset.set("commands.bedwars.preset.enable", "§aPresets have been succesfully enabled");
	        	 preset.set("commands.bedwars.preset.disable", "§aPresets have been succesfully disabled");
	        	 preset.set("commands.bedwars.preset.nopresets", "§cYou dont have any presets !");
	        	 preset.set("commands.bedwars.preset.list", "§aPresets List :");
	        	
	        	 preset.set("commands.bedwars.preset.current", "§aThe current preset is : §6");
	        	 preset.set("commands.bedwars.preset.currentdis", "§cWARNING : Presets are disabled"
		        	 		+ "\n§aThe actual saved preset is : §6");
	        	 
	        	 preset.set("commands.bedwars.preset.invalid", "§cInvalid command...");
	        	 preset.set("commands.bedwars.preset.create", "§cThis file already exist");
	        	 preset.set("commands.bedwars.preset.doesntexist", "§cThis preset doesnt exist");
	        	 preset.set("commands.bedwars.preset.delete", "§4WARNING : §cThis action will definitively delete this filer"
		        	 		+ "\nConfirm by typing : /bedwars preset deleteconfirm ");
		        	 
		         preset.set("commands.bedwars.preset.deleteconfimcfg", "§lYou deleted the preset save in the config, it has been replaced by 'null'");
	        	 
		         preset.createSection("gui");
	        	 preset.set("gui.ironshop", "§l§8Iron Shop");
	        	 
	        	 
	        	 preset.createSection("items");
	        	 
	        	 preset.set("items.iron_ingot", "§7Iron Ingot");
	        	 preset.set("items.gold_ingot", "§6Gold Ingot");
	        	 preset.set("items.diamond", "§bDiamond");
	        	 preset.set("items.emerald", "§2Emerald");
	        	 
	        	 
	        	 preset.set("items.blockgui", "§fBuilding Blocks");
	        	 preset.set("items.woolblock", "Wool");
	        	 preset.set("items.woodblock", "§fWooden Planks");
	        	 preset.set("items.endstone", "§7Endstone");
	        	 
	        	 preset.set("items.swordgui", "§7Swords");
	        	 preset.set("items.stonesword", "§7Stone Sword");
	        	 preset.set("items.ironsword", "§7Iron Sword");
	        	 preset.set("items.diamondsword", "§bDiamond Sword");
	        	 
	        	 preset.set("items.armorgui", "§6Armors");
	        	 preset.set("items.leather_armor", "Leather Armor");
	        	 preset.set("items.ironarmor", "§7Iron Armor");
	        	 preset.set("items.diamond_armor", "§bDiamond Armor");
	        	 
	        	 preset.set("items.toolgui", "§6Tools");
	        	 preset.set("items.woodpick", "§7Wooden Pickaxe");
	        	 preset.set("items.woodaxe", "§7Wooden Axe");
	        	 preset.set("items.shears", "§7Shears");
	        	 
	        	 preset.set("items.bowgui", "§6Bows");
	        	 preset.set("items.normalbow", "§fBow");
	        	 preset.set("items.punchbow", "§2Punch I Bow");
	        	 preset.set("items.arrow", "§fArrows");
	        	 
	        	 preset.set("items.potgui", "§2Potions");

	        	 preset.set("items.utilgui", "§aUtils");
	        	 preset.set("items.tnt", "§4TNT");
	        	 
	             preset.save(f);
	             
	         } catch (IOException exception) {

	             exception.printStackTrace();
	         }
	     }
	     }
	    
	    public static boolean doesExist() {
	    	File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Baidouars").getDataFolder(), File.separator + "lang");
	        File f = new File(userdata, File.separator + "en_us.yml");
	        
	        if (!f.exists()) {
	        	 return false;
	        } else {
	        	return true;
	        }
	    }
	    
	    public static FileConfiguration get() {
	    	
	    	File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Baidouars").getDataFolder(), File.separator + "lang");
		    File f = new File(userdata, File.separator + "en_us.yml");
		    FileConfiguration lang = YamlConfiguration.loadConfiguration(f);
		    if(doesExist()) {
		    	return lang;
		    } else {
		    	fileCheck();
		    	return lang;
		    }
	    }
}
