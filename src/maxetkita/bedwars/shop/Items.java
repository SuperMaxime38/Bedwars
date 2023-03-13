package maxetkita.bedwars.shop;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import maxetkita.bedwars.Bedwars;
import maxetkita.bedwars.managers.LanguagesManager;
import maxetkita.bedwars.managers.TeamsManager;

public class Items {
	
	private static FileConfiguration config;
	private static FileConfiguration lang;
	private static Player p;
	public Items(Bedwars main, Player p) {
		Items.config = main.getConfig();
		Items.p = p;
		Items.lang = LanguagesManager.getLang(main);
	}
	
	//Blocks
	public ItemStack woolBlock() {
		ChatColor c = TeamsManager.getPlayerTeamColor(config, p);
		Material mat;
		switch(c) {
		case RED:
			mat = Material.RED_WOOL;
			break;
		case BLUE:
			mat = Material.BLUE_WOOL;
			break;
		case GREEN:
			mat = Material.GREEN_WOOL;
			break;
		case YELLOW:
			mat = Material.YELLOW_WOOL;
			break;
		default:
			mat = Material.WHITE_WOOL;
			break;
		}
		ItemStack item = new ItemStack(mat, 16);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(c + lang.getString("items.woolblock"));
		meta.setLore(Arrays.asList("§7x16 " + lang.getString("items.iron_ingot")));
		item.setItemMeta(meta);
		
		return item;
	}
	public ItemStack woodBlock() {
		ItemStack item = new ItemStack(Material.OAK_PLANKS, 16);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(lang.getString("items.woodblock"));
		meta.setLore(Arrays.asList("§6x16 " + lang.getString("items.gold_ingot")));
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack endstoneBlock() {
		ItemStack item = new ItemStack(Material.END_STONE, 12);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(lang.getString("items.enstone"));
		meta.setLore(Arrays.asList("§7x24 " + lang.getString("items.iron_ingot")));
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack terraBlock(boolean gui) {
		ChatColor c = TeamsManager.getPlayerTeamColor(config, p);
		Material mat;
		switch(c) {
		case RED:
			mat = Material.RED_TERRACOTTA;
			break;
		case BLUE:
			mat = Material.BLUE_TERRACOTTA;
			break;
		case GREEN:
			mat = Material.GREEN_TERRACOTTA;
			break;
		case YELLOW:
			mat = Material.YELLOW_TERRACOTTA;
			break;
		default:
			mat = Material.WHITE_TERRACOTTA;
			break;
		}
		ItemStack item = new ItemStack(mat);
		ItemMeta meta = item.getItemMeta();
		if(gui == true) {
			meta.setDisplayName(lang.getString("items.blockgui"));
		} else {
			meta.setDisplayName(c + "Terracotta");
		}
		item.setItemMeta(meta);
		return item;
	}
	
	//Swords
	public ItemStack ironSword(boolean gui) {
		ItemStack item = new ItemStack(Material.IRON_SWORD);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		if(gui == true) {
			meta.setDisplayName(lang.getString("items.swordgui"));
		} else {
			meta.setDisplayName(lang.getString("items.ironsword"));
			meta.setLore(Arrays.asList("§6x7 " + lang.getString("items.gold_ingot")));
		}
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack stoneSword() {
		ItemStack item = new ItemStack(Material.STONE_SWORD);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setDisplayName(lang.getString("items.stonesword"));
		meta.setLore(Arrays.asList("§7x10 " + lang.getString("items.iron_ingot")));
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack diamondSword() {
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setDisplayName(lang.getString("items.diamondsword"));
		meta.setLore(Arrays.asList("§2x4  " + lang.getString("items.emerald")));
		item.setItemMeta(meta);
		return item;
	}
	
	//Armors
	public ItemStack ironArmor(boolean gui) {
		ItemStack item = new ItemStack(Material.IRON_BOOTS);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		if(gui == true) {
			meta.setDisplayName(lang.getString("items.armorgui"));
		} else {
			meta.setDisplayName(lang.getString("items.ironarmor"));
			meta.setLore(Arrays.asList("§6x12 " + lang.getString("items.gold_ingot")));
		}
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack leatherArmor() {
		ChatColor c = TeamsManager.getPlayerTeamColor(config, p);
		ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		meta.setDisplayName(c + lang.getString("items.leather_armor"));
		meta.addItemFlags(ItemFlag.HIDE_DYE);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setLore(Arrays.asList("§7x20 " + lang.getString("items.iron_ingot")));
		switch(c) {
		case RED:
			meta.setColor(Color.RED);
			break;
		case BLUE:
			meta.setColor(Color.BLUE);
			break;
		case GREEN:
			meta.setColor(Color.GREEN);
			break;
		case YELLOW:
			meta.setColor(Color.YELLOW);
			break;
		default:
			meta.setColor(Color.WHITE);
			break;
		}
		item.setItemMeta(meta);
		
		return item;
	}
	
	public ItemStack diamondArmor() {
		ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setDisplayName(lang.getString("items.diamond_armor"));
		meta.setLore(Arrays.asList("§2x6 " + lang.getString("items.emerald")));
		item.setItemMeta(meta);
		return item;
	}
	
	//Tools
	public ItemStack woodPickaxe(boolean gui) {
		ItemStack item = new ItemStack(Material.WOODEN_PICKAXE);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		if(gui == true) {
			meta.setDisplayName(lang.getString("items.toolgui"));
		} else {
			meta.setDisplayName(lang.getString("items.woodpick"));
			meta.setLore(Arrays.asList("§7x10 " + lang.getString("items.iron_ingot")));
		}
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack woodAxe() {
		ItemStack item = new ItemStack(Material.WOODEN_AXE);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setDisplayName(lang.getString("items.woodaxe"));
		meta.setLore(Arrays.asList("§7x10 " + lang.getString("items.iron_ingot")));
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack shears() {
		ItemStack item = new ItemStack(Material.SHEARS);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setDisplayName(lang.getString("items.shears"));
		meta.setLore(Arrays.asList("§7x20 " + lang.getString("items.iron_ingot")));
		item.setItemMeta(meta);
		return item;
	}
	
	//Bows
	public ItemStack normalBow(boolean gui) {
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		if(gui == true) {
			meta.setDisplayName(lang.getString("items.bowgui"));
		} else {
			meta.setDisplayName(lang.getString("items.normalbow"));
			meta.setLore(Arrays.asList("§6x12 " + lang.getString("items.gold_ingot")));
		}
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack punchBow() {
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setDisplayName(lang.getString("items.punchbow"));
		meta.setLore(Arrays.asList("§2x6 " + lang.getString("items.emerald")));
		meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, false);
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack arrows() {
		ItemStack item = new ItemStack(Material.ARROW, 8);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(lang.getString("items.arrow"));
		meta.setLore(Arrays.asList("§6x2 " + lang.getString("items.gold_ingot")));
		item.setItemMeta(meta);
		return item;
	}
	
    //Potions
	public ItemStack potGui() {
		ItemStack item = new ItemStack(Material.BREWING_STAND);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(lang.getString("items.potgui"));
		item.setItemMeta(meta);
		return item;
	}
		
	//Bows
	public ItemStack tnt(boolean gui) {
		ItemStack item = new ItemStack(Material.TNT);
		ItemMeta meta = item.getItemMeta();
		if(gui == true) {
			meta.setDisplayName(lang.getString("items.utilgui"));
		} else {
			meta.setDisplayName(lang.getString("items.tnt"));
		}
		item.setItemMeta(meta);
		return item;
	}
}
