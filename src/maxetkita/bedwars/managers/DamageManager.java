package maxetkita.bedwars.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import maxetkita.bedwars.Bedwars;

public class DamageManager implements Listener{
	
	private static Bedwars main;
	private static FileConfiguration config;
	public DamageManager(Bedwars main) {
		DamageManager.main = main;
		config = PresetManager.getPreset(main);
	}

	@EventHandler
	public static void onDamage(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player) {
			if(e.getEntity() instanceof Player) {
				Player damager = (Player) e.getDamager();
				Player p = (Player) e.getEntity();
				
				String pteam = TeamsManager.getPlayerTeam(config, p);
				String dteam = TeamsManager.getPlayerTeam(config, damager);
				
				if(pteam.equals("none")) { //Si le joueur frappe n'est pas dans une team
					e.setCancelled(true);
					return;
				}
				if(dteam.equals("none")) {//Si l'attaquant n'est pas dans une team
					e.setCancelled(true);
					return;
				}
				if(pteam.equals(dteam)) {//Si les 2 joueurs sont dans une team
					e.setCancelled(true);
					return;
				}
				
				double dmg = 1;
				@SuppressWarnings("deprecation")
				ItemStack item = damager.getItemInHand();
				if(item == null) {
					dmg = 1;
					return;
				}
				
				boolean isEnchant = item.getItemMeta().hasEnchants();
				
				if(main.getConfig().getBoolean("custom-damage") == false) {
					return;
				}
				
				switch(item.getType()) {
				case WOODEN_SWORD:
					if(isEnchant == true) {
						dmg = 2.5;
					} else {
						dmg = 3.125;
					}
					break;
				case WOODEN_AXE:
					dmg = 2.6;
					break;
				case WOODEN_PICKAXE:
					dmg = 1.5;
					break;
				case STONE_SWORD:
					if(isEnchant == true) {
						dmg = 3;
					} else {
						dmg = 3.75;
					}
					break;
				case STONE_AXE:
					dmg = 2.9;
					break;
				case STONE_PICKAXE:
					dmg = 2.25;
					break;
				case IRON_SWORD:
					if(isEnchant == true) {
						dmg = 4.25;
					} else {
						dmg = 5.3125;
					}
					break;
				case IRON_AXE:
					dmg = 4;
					break;
				case IRON_PICKAXE:
					dmg = 2.75;
					return;
				case DIAMOND_SWORD:
					if(isEnchant == true) {
						dmg = 4.75;
					} else {
						dmg = 6;
					}
					break;
				default:
					dmg = 1;
					break;
				}
				
				e.setDamage(dmg);
				
			} else {
				return;
			}
		} else {
			return;
		}
	}
	
	public static void specialDamages(EntityDamageByEntityEvent e) { //Damaged by tnts, fireballs, etc...
		
	}

}
