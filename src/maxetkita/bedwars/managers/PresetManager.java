package maxetkita.bedwars.managers;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import maxetkita.bedwars.Bedwars;

public class PresetManager {
	
	//Bedwars plugin = Bedwars.getPlugin(Bedwars.class);
	   
    public static void fileCheck(String name, Bedwars main){
    	
     File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Baidouars").getDataFolder(), File.separator + "presets");
     File f = new File(userdata, File.separator + name + ".yml");
     FileConfiguration preset = YamlConfiguration.loadConfiguration(f);

     FileConfiguration config = main.getConfig();
     
     if (!f.exists()) {
         try {
        	 
        	 preset.set("comment", "The schematics must be a world edit one. Save it in the 'plugin/WorldEdit/schematics' folder. No need to put '.schem' in the parameter 'file' below");
        	 preset.createSection("map");
        	 preset.set("map", config.getConfigurationSection("map"));
        	
        	 preset.createSection("bed");
        	 preset.set("bed", config.getConfigurationSection("bed"));
        	 
        	 preset.createSection("iron-gen");
        	 preset.set("iron-gen", config.getConfigurationSection("iron-gen"));
        	 
        	 preset.createSection("diamond-gen");
        	 preset.set("diamond-gen", config.getConfigurationSection("diamond-gen"));
        	 
        	 preset.createSection("emerald-gen");
        	 preset.set("emerald-gen", config.getConfigurationSection("emerald-gen"));
        	 
        	 preset.createSection("npc");
        	 preset.set("npc", config.getConfigurationSection("npc"));
        	 
             preset.save(f);
             
         } catch (IOException exception) {

             exception.printStackTrace();
         }
     }
     }
    
    public static boolean doesExist(String name) {
    	File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Baidouars").getDataFolder(), File.separator + "presets");
        File f = new File(userdata, File.separator + name + ".yml");
        
        if (!f.exists()) {
        	 return false;
        } else {
        	return true;
        }
    }
    
    public static FileConfiguration getPreset(Bedwars main) {
    	FileConfiguration preset;
    	if(main.getConfig().getBoolean("preset.enable") == true) {
    		String name = main.getConfig().getString("preset.name");
    		File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Baidouars").getDataFolder(), File.separator + "presets");
    	    File f = new File(userdata, File.separator + name + ".yml");
    	    
    	    if(!f.exists()) {
    	    	System.out.println(ChatColor.RED + "ERROR - This preset doesnt exist | Using config.yml datas");
    	    	return main.getConfig();
    	    } else {
    	    	 preset = YamlConfiguration.loadConfiguration(f);
    	    	 System.out.println(ChatColor.GREEN + "Succesfully loaded " + name + " preset");
    	    	 return preset;
    	    }
    	} else {
    		return main.getConfig();
    	}
    }
}
