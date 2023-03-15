package maxetkita.bedwars.managers;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import maxetkita.bedwars.Bedwars;
import maxetkita.bedwars.lang.LangEN;
import maxetkita.bedwars.lang.LangFR;

public class LanguagesManager {
	
	public enum Lang {
		fr_fr,
		en_us
	}
	
	 public static boolean doesExist(String name) {
	    	File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Baidouars").getDataFolder(), File.separator + "lang");
	        File f = new File(userdata, File.separator + name + ".yml");
	        
	        if (!f.exists()) {
	        	if(Lang.valueOf(name) != null) {
	        		switch(name) {
	        		case "fr_fr":
	        			LangFR.fileCheck();
	        			System.out.println("[Lang] > File doesnt exist, generating it...");
	        			break;
	        		case "en_us":
	        			LangEN.fileCheck();
	        			System.out.println("[Lang] > File doesnt exist, generating it...");
	        			break;
	        		}
	        	}
	        	return false;
	        } else {
	        	return true;
	        }
	  }
	 
	 public static FileConfiguration getLang(Bedwars main) {
	    	FileConfiguration lang;
	    		String name = main.getConfig().getString("lang");
	    		File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Baidouars").getDataFolder(), File.separator + "lang");
	    	    File f = new File(userdata, File.separator + name + ".yml");
	    	    
	    	    if(!f.exists()) {
	    	    	System.out.println(ChatColor.RED + "ERROR - This lang doesnt exist | Using en_us.yml datas");
	    	    	return LangEN.get();
	    	    } else {
	    	    	lang = YamlConfiguration.loadConfiguration(f);
    	    		return lang;
	    	    }
	    }
}
