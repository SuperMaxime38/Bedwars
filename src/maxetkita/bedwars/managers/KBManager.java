package maxetkita.bedwars.managers;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import maxetkita.bedwars.Bedwars;

public class KBManager implements Listener{
	
	private static FileConfiguration config;
	private static Bedwars main;
	public KBManager(Bedwars main) {
		config = main.getConfig();
		KBManager.main = main;
	}
	
	@EventHandler
	public static void vectorKb(EntityDamageByEntityEvent e) {
		if(main.getConfig().getBoolean("custom-kb.enable") == false) {
			System.out.println("test");
			return;
		} else {
			if(e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				String team = TeamsManager.getPlayerTeam(config, p);
				if(team.equals("none")) return;
				
				if(e.getDamager() instanceof TNTPrimed) {
					double multiplier = main.getConfig().getDouble("custom-kb.tnt-multiplier");
					Location loc1 = e.getDamager().getLocation();
					Location loc2 = e.getEntity().getLocation();
					if(loc2.getX() < loc1.getX()) {
						loc1.setX(-loc1.getX());
					}
					if(loc2.getY() < loc1.getY()) {
						loc1.setY(-loc1.getY());
					}
					if(loc2.getZ() < loc1.getZ()) {
						loc1.setZ(-loc1.getZ());
					}
					
					double X = loc2.getX() - loc1.getX();
					double Y = (loc2.getY() - loc1.getY()) + 0.25;
					double Z = loc2.getZ() - loc1.getZ();
					
					Vector v = new Vector(X, Y, Z);
					v.multiply(multiplier);
					Vector velocity = p.getVelocity();
					velocity = velocity.add(v);
					p.setVelocity(velocity);
					
				} else if(e.getDamager() instanceof Fireball) {
					
				} else {
					return;
				}
			}
		}
	}
}
