package maxetkita.bedwars.shop;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import maxetkita.bedwars.Bedwars;
import maxetkita.bedwars.managers.LanguagesManager;
import maxetkita.bedwars.managers.PresetManager;
import maxetkita.bedwars.managers.TeamsManager;

public class IronNPC implements Listener{
	
	private static FileConfiguration config;
	private static FileConfiguration lang;
	private static Bedwars main;
	public IronNPC(Bedwars main) {
		config = PresetManager.getPreset(main);
		IronNPC.main = main;
		lang = LanguagesManager.getLang(main);
	}
	
	public static void spawnIronNPC(Bedwars main) {
		double redX = config.getDouble("npc.iron.red.locX");
		double redY = config.getDouble("npc.iron.red.locY");
		double redZ = config.getDouble("npc.iron.red.locZ");
		
		double blueX = config.getDouble("npc.iron.blue.locX");
		double blueY = config.getDouble("npc.iron.blue.locY");
		double blueZ = config.getDouble("npc.iron.blue.locZ");
		
		double greenX = config.getDouble("npc.iron.green.locX");
		double greenY = config.getDouble("npc.iron.green.locY");
		double greenZ = config.getDouble("npc.iron.green.locZ");
		
		double yellowX = config.getDouble("npc.iron.yellow.locX");
		double yellowY = config.getDouble("npc.iron.yellow.locY");
		double yellowZ = config.getDouble("npc.iron.yellow.locZ");
		
		Location red = new Location(Bukkit.getWorld("world"), redX, redY, redZ);
		Location blue = new Location(Bukkit.getWorld("world"), blueX, blueY, blueZ);
		Location green = new Location(Bukkit.getWorld("world"), greenX, greenY, greenZ);
		Location yellow = new Location(Bukkit.getWorld("world"), yellowX, yellowY, yellowZ);
		
		setIronNPC(red);
		setIronNPC(blue);
		setIronNPC(green);
		setIronNPC(yellow);
		
		
	}
	
	public static void setIronNPC(Location loc) {
		Villager e = (Villager) loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);
		e.setAdult();
		e.setAI(false);
		e.setInvulnerable(true);
		e.setGravity(false);
		e.setCustomName("§l§7Iron Shop");
		e.setCanPickupItems(false);
		e.setPersistent(true);
		e.setProfession(Profession.NONE);
		e.setCollidable(false);
	}
	
	@EventHandler
	public static void cancelDamage(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Villager) {
			String name = e.getEntity().getCustomName();
			if(name.equals("§l§7Iron Shop")) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public static void onInteract(PlayerInteractAtEntityEvent e) {
		Player p = e.getPlayer();
		String team = TeamsManager.getPlayerTeam(config, p);
		if(team.equals("none")) {
			return;
		} else {
			if(e.getRightClicked() instanceof Villager) {
				Villager v = (Villager) e.getRightClicked();
				if(v.getCustomName().contains("Iron Shop")) {
					Inventory inv = Bukkit.createInventory(null, 54, lang.getString("gui.ironshop"));
					ItemStack pane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
					ItemMeta meta = pane.getItemMeta();
					meta.setDisplayName(ChatColor.RESET + "");
					pane.setItemMeta(meta);
					for(int i = 0; i< 54; i++) {
						inv.setItem(i, pane);
					}
					Items it = new Items(main, p);
					inv.setItem(1, it.terraBlock(true)); //true means its a GUI icon
					inv.setItem(2, it.ironSword(true));
					inv.setItem(3, it.ironArmor(true));
					inv.setItem(4, it.woodPickaxe(true));
					inv.setItem(5, it.normalBow(true));
					inv.setItem(6, it.potGui()); //this one is a brewing stand it isnt a buyable item
					inv.setItem(7, it.tnt(true));
					
					//Blocks
					inv.setItem(19, it.woolBlock());
					inv.setItem(28, it.woodBlock());
					inv.setItem(37, it.endstoneBlock());
					
					//Swords
					inv.setItem(20, it.stoneSword());
					inv.setItem(29, it.ironSword(false));
					inv.setItem(38, it.diamondSword());
					
					//Armors
					inv.setItem(21, it.leatherArmor());
					inv.setItem(30, it.ironArmor(false));
					inv.setItem(39, it.diamondArmor());
					
					//Tools
					inv.setItem(22, it.woodPickaxe(false));
					inv.setItem(31, it.woodAxe());
					inv.setItem(40, it.shears());
					
					//Bows

					inv.setItem(23, it.normalBow(false));
					inv.setItem(32, it.punchBow());
					inv.setItem(41, it.arrows());
					
					
					p.openInventory(inv);
				} else {
					return;
				}
			} else {
				return;
			}
		}
	}
	
	@EventHandler
	public static void clickItem(InventoryClickEvent e) {
		if(!(e.getWhoClicked() instanceof Player)) return;
		if(e.getView().getTitle().equals(lang.getString("gui.ironshop"))) {
			e.setCancelled(true);
		}
	}
}
