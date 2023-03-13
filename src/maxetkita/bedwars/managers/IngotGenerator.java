package maxetkita.bedwars.managers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import maxetkita.bedwars.Bedwars;

public class IngotGenerator {
	
	public static void generateAll(Bedwars main) {
		generateIron(main);
		generateDiamond(main);
		generateEmerald(main);
	}
	
	public static void generateIron(Bedwars main) {
		long speed = main.getConfig().getLong("iron-gen.speed") * 20;
		long goldspeed = main.getConfig().getLong("iron-gen.gold-speed") * 20;
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
		
		ItemStack iron = new ItemStack(Material.IRON_INGOT, 1);
		ItemStack gold = new ItemStack(Material.GOLD_INGOT, 1);
		
		new BukkitRunnable(){
            @Override
            public void run(){
            	boolean activated = main.getConfig().getBoolean("enable");
            	if(activated == true) {
            		red.getWorld().dropItem(red, iron);
            		blue.getWorld().dropItem(blue, iron);
            		green.getWorld().dropItem(green, iron);
            		yellow.getWorld().dropItem(yellow, iron);
            	}
            }
        }.runTaskTimer(main, 20, speed);
        
        new BukkitRunnable(){
            @Override
            public void run(){
            	boolean activated = main.getConfig().getBoolean("enable");
            	if(activated == true) {
            		red.getWorld().dropItem(red, gold);
            		blue.getWorld().dropItem(blue, gold);
            		green.getWorld().dropItem(green, gold);
            		yellow.getWorld().dropItem(yellow, gold);
            	}
            }
        }.runTaskTimer(main, 40, goldspeed);
        
	}
	
	public static void generateDiamond(Bedwars main) {
		long speed = main.getConfig().getLong("diamond-gen.speed") * 20;
		int RGx = main.getConfig().getInt("diamond-gen.gen-rg.locX");
		int RGy = main.getConfig().getInt("diamond-gen.gen-rg.locY");
		int RGz = main.getConfig().getInt("diamond-gen.gen-rg.locZ");
		
		int RYx = main.getConfig().getInt("diamond-gen.gen-ry.locX");
		int RYy = main.getConfig().getInt("diamond-gen.gen-ry.locY");
		int RYz = main.getConfig().getInt("diamond-gen.gen-ry.locZ");
		
		int BGx = main.getConfig().getInt("diamond-gen.gen-bg.locX");
		int BGy = main.getConfig().getInt("diamond-gen.gen-bg.locY");
		int BGz = main.getConfig().getInt("diamond-gen.gen-bgn.locZ");
		
		int BYx = main.getConfig().getInt("diamond-gen.gen-by.locX");
		int BYy = main.getConfig().getInt("diamond-gen.gen-by.locY");
		int BYz = main.getConfig().getInt("diamond-gen.gen-by.locZ");
		
		Location rg = new Location(Bukkit.getWorld("world"), RGx, RGy, RGz);
		Location ry = new Location(Bukkit.getWorld("world"), RYx, RYy, RYz);
		Location bg = new Location(Bukkit.getWorld("world"), BGx, BGy, BGz);
		Location by = new Location(Bukkit.getWorld("world"), BYx, BYy, BYz);
		
		ItemStack d = new ItemStack(Material.DIAMOND, 1);
		
		new BukkitRunnable(){
            @Override
            public void run(){
            	boolean activated = main.getConfig().getBoolean("enable");
            	if(activated == true) {
            		rg.getWorld().dropItem(rg, d);
            		ry.getWorld().dropItem(ry, d);
            		bg.getWorld().dropItem(bg, d);
            		by.getWorld().dropItem(by, d);
            	}
            }
        }.runTaskTimer(main, 100, speed);
        
	}
	
	public static void generateEmerald(Bedwars main) {
		long speed = main.getConfig().getLong("emerald-gen.speed") * 20;
		int Rx = main.getConfig().getInt("emerald-gen.gen1.locX");
		int Ry = main.getConfig().getInt("emerald-gen.gen1.locY");
		int Rz = main.getConfig().getInt("emerald-gen.gen1.locZ");
		
		int Bx = main.getConfig().getInt("emerald-gen.gen2.locX");
		int By = main.getConfig().getInt("emerald-gen.gen2.locY");
		int Bz = main.getConfig().getInt("emerald-gen.gen2.locZ");
		
		Location red = new Location(Bukkit.getWorld("world"), Rx, Ry, Rz);
		Location blue = new Location(Bukkit.getWorld("world"), Bx, By, Bz);
		
		ItemStack e = new ItemStack(Material.EMERALD, 1);
		
		new BukkitRunnable(){
            @Override
            public void run(){
            	boolean activated = main.getConfig().getBoolean("enable");
            	if(activated == true) {
            		red.getWorld().dropItem(red, e);
            		blue.getWorld().dropItem(blue, e);
            	}
            }
        }.runTaskTimer(main, 200, speed);
        
	}
}
