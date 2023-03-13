package maxetkita.bedwars.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import maxetkita.bedwars.Bedwars;
import maxetkita.bedwars.managers.PresetManager;
import maxetkita.bedwars.managers.TeamsManager;

public class DeathListener implements Listener{
	
	private static Bedwars main;
	private static FileConfiguration config;
	public DeathListener(Bedwars main) {
		DeathListener.main = main;
		config = PresetManager.getPreset(main);
	}
	
	@EventHandler
	public static void fallen(PlayerMoveEvent e) {
		if(main.getConfig().getBoolean("enable") == true) {
			Player p = e.getPlayer();
			
			String team = TeamsManager.getPlayerTeam(main.getConfig(), p);
			if(team.equals("none")) return;
			
			ChatColor c = TeamsManager.getPlayerTeamColor(main.getConfig(), p);
			double minY = config.getDouble("map.minY");
			
			if(p.getLocation().getY() < minY) {
				p.setHealth(0.1);
				Bukkit.broadcastMessage(c + p.getDisplayName() + " §ffell into the void");
			}
		}
	}
	
	@EventHandler
	public static void playerDeath(EntityDamageEvent e) {
		if(main.getConfig().getBoolean("enable") == true) {
			if(e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				
				String team = TeamsManager.getPlayerTeam(main.getConfig(), p);
				if(team.equals("none")) return;
				
				if(p.getHealth() <= 0.1) {
					p.setHealth(1);
					p.setGameMode(GameMode.SPECTATOR);
					respawn(p);
				}
			}
		}
	}
	
	public static void respawn(Player p) {
		boolean activated = main.getConfig().getBoolean("enable");
    	if(activated == false) {
    		System.out.println("[Baidouars] > A player died even with the game disbaled...");
    		return;
    	}
    	String team = TeamsManager.getPlayerTeam(main.getConfig(), p);
    	if(team.equals("none")) {
    		System.out.println("[Baidouars] > A player died but he wasnt in a team...");
    		return;
    	}
    	boolean hasBed = config.getBoolean("bed." + team + ".alive");
    	
		new BukkitRunnable(){
			int i = main.getConfig().getInt("respawn-delay");
            @Override
            public void run(){
            	if(i <= 0) this.cancel();
            	if(hasBed == true) {
    				p.sendTitle("§4You are dead", "You will respawn in " + i + " seconds", 0, 20, 0); //Creer une traduction
            	} else {
    				p.sendTitle("§4You are dead & your bed is destroyed", "You wont respawn...", 0, 60, 20); //Creer une traduction
            	}
            	i--;
            }
        }.runTaskTimer(main, 0, 20);
	}
}
