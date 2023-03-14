package maxetkita.bedwars.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import maxetkita.bedwars.Bedwars;
import maxetkita.bedwars.fancy.CustomKillDeathMessage;
import maxetkita.bedwars.managers.PresetManager;
import maxetkita.bedwars.managers.TeamsManager;
import maxetkita.bedwars.utils.Locations;

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
			
			double minY = config.getDouble("map.minY");
			
			if(p.getLocation().getY() < minY) {
				p.setHealth(0);
				p.setLastDamageCause(new EntityDamageEvent(p, DamageCause.VOID, 0));
				Bukkit.broadcastMessage(CustomKillDeathMessage.VoidMessage(config, p));
			}
		}
	}
	
	@EventHandler
	public static void playerDeath(PlayerDeathEvent e) {
		if(main.getConfig().getBoolean("enable") == true) {
				Player p = (Player) e.getEntity();
				
				String team = TeamsManager.getPlayerTeam(main.getConfig(), p);
				if(team.equals("none")) return;
				p.spigot().respawn();
				p.setGameMode(GameMode.SPECTATOR);
				Location loc = Locations.getSpawnLocation(team, config, main);
				loc.add(0, 32, 0);
				p.teleport(loc);
				respawnDelay(p);
		}
	}
	
	public static void respawnDelay(Player p) {
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
            	if(i <= 0) {
            		respawn(p);
            		this.cancel();
            	}
            	if(hasBed == true) {
    				p.sendTitle("§4You are dead", "You will respawn in " + i + " seconds", 0, 21, 0); //Creer une traduction
            	} else {
    				p.sendTitle("§4You are dead & your bed is destroyed", "You wont respawn...", 0, 60, 20); //Creer une traduction
            	}
            	i--;
            }
        }.runTaskTimer(main, 0, 20);
	}
	
	public static void respawn(Player p) {
		String team = TeamsManager.getPlayerTeam(config, p);
		Location loc = Locations.getSpawnLocation(team, config, main);
		loc.add(0, 1.5, 0);
		p.teleport(loc);
		p.setGameMode(GameMode.SURVIVAL);
	}
	
	@EventHandler
	public static void deathByPlayer(EntityDamageByEntityEvent e) { //A TESTER
		if(!(e.getDamager() instanceof Player)) return;
		if(!(e.getEntity() instanceof Player)) return;
		if(!e.getEntity().isDead()) return;
		Player p = (Player) e.getEntity();
		Player killer = (Player) e.getDamager();
		if(TeamsManager.getPlayerTeam(config, p).equals("none")) return;
		if(TeamsManager.getPlayerTeam(config, killer).equals("none")) return;
		
		Bukkit.broadcastMessage(CustomKillDeathMessage.KillMessage(config, p, killer));
		
	}
	
	@EventHandler
	public static void otherDeaths(EntityDeathEvent e) {
		if(!(e.getEntity() instanceof Player)) return;
		Player p = (Player) e.getEntity();
		if(TeamsManager.getPlayerTeam(config, p).equals("none")) return;
		EntityDamageEvent event = e.getEntity().getLastDamageCause();
		DamageCause dmg = event.getCause();
		
		String msg;
		
		switch(dmg) { //Switch des causes pr CustomKillDeathsMessages
		default:
			msg = "";
			break;
		case VOID:
			msg = CustomKillDeathMessage.VoidMessage(config, p);
			break;
		case FIRE:
			msg = CustomKillDeathMessage.FireDeathMessage(config, p);
			break;
		case FIRE_TICK:
			msg = CustomKillDeathMessage.FireDeathMessage(config, p);
			break;
		}
		
		Bukkit.broadcastMessage(msg);
	}
	
}
