package maxetkita.bedwars.managers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import maxetkita.bedwars.Bedwars;

public class MapGenerator {
	
	public static void genMap(Bedwars main) {
		
		FileConfiguration config = PresetManager.getPreset(main);
		
		
		String name = config.getString("map.file");
		int pos1X = config.getInt("map.pos1.X");
		int pos1Y = config.getInt("map.pos1.Y");
		int pos1Z = config.getInt("map.pos1.Z");
		
		int pos2X = config.getInt("map.pos2.X");
		int pos2Y = config.getInt("map.pos2.Y");
		int pos2Z = config.getInt("map.pos2.Z");
        
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "/world world");
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "/schem load " + name);
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "/pos1 " + pos1X + "," + pos1Y + "," + pos1Z);
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "/pos2 " + pos2X + "," + pos2Y + "," + pos2Z);
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "/paste");
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "/world world");
	}
	
}
