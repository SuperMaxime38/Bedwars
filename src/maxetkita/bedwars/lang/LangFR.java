package maxetkita.bedwars.lang;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class LangFR {
	 public static void fileCheck(){
	    	
	     File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Baidouars").getDataFolder(), File.separator + "lang");
	     File f = new File(userdata, File.separator + "fr_fr.yml");
	     FileConfiguration preset = YamlConfiguration.loadConfiguration(f);
	     
	     if (!f.exists()) {
	         try {
	        	 
	        	 //Commandes
	        	 
	        	 preset.createSection("commands");
	        	 
	        	 preset.set("commands.bedwars.noargs", "§aListe des commandes pour §6/bedwars §f:"
	        	 		+ "\n§6/bedwars preset §f: Commande de gestion des presets de maps"
	        	 		+ "\n§6/bedwars start §f: Permet de démarrer une game");
	        	 
	        	 preset.set("commands.bedwars.preset.noargs", "§aListe des commandes pour §6/bedwars preset §f:");
	        	 preset.set("commands.bedwars.preset.cmdlist", "§6/bedwars preset create <name> §f: Permet de créer un nouveau preset"
	        	 		+ "\n§6/bedwars preset load <name> §f: Permet de changer de preset"
	        	 		+ "\n§6/bedwars preset delete <name> §f: Permet de supprimer un preset"
	        	 		+ "\n§6/bedwars preset enable §f: Permet l'utilisation des presets"
	        	 		+ "\n§6/bedwars preset disable §f: Desactive les presets et utilise le fichier §aconfig.yml"
	        	 		+ "\n§6/bedwars preset list §f: Accede à la liste des presets"
	        	 		+ "\n§6/bedwars preset current §f: Affiche le preset actuel");
	        	 
	        	 preset.set("commands.bedwars.preset.enable", "§aLes presets ont été activés avec succes");
	        	 preset.set("commands.bedwars.preset.disable", "§aLes presets ont été désctivés avec succes");
	        	 preset.set("commands.bedwars.preset.nopresets", "§cVous n'avez aucun presets");
	        	 preset.set("commands.bedwars.preset.list", "§aListe des presets :");
	        	 
	        	 preset.set("commands.bedwars.preset.current", "§aLe preset actuel est : §6");
	        	 preset.set("commands.bedwars.preset.currentdis", "§cATTENTION : Les presets sont désactivés"
	        	 		+ "\n§aLe preset actuellement enregistré est : §6");
	        	 
	        	 preset.set("commands.bedwars.preset.invalid", "§cCommande invalide...");
	        	 preset.set("commands.bedwars.preset.create", "§cCe fichier existe déja");
	        	 preset.set("commands.bedwars.preset.doesntexist", "§cCe preset n'existe pas");
	        	 preset.set("commands.bedwars.preset.delete", "§4ATTENTION : §cCette action supprimera definitivement le fichier"
	        	 		+ "\nConfirmez en tapant : /bedwars preset deleteconfirm ");
	        	 
	        	 preset.set("commands.bedwars.preset.deleteconfimcfg", "§lVous avez suprimmé le preset enregistré dans la config, le nom a été remplacé par 'null'");
		         
	        	 preset.set("commands.bedwars.start", "§aVous avez commencé une partie de Bedwars !");

		         preset.set("commands.lang.noargs", "Le langage actuel est : §afr_fr");
		         preset.set("commands.lang.noargs2", "Faites §6/bw lang <nom_langue> §fpour changer de langue");
		         preset.set("commands.lang.changed", "Langue changée sur Français");
		         preset.set("commands.lang.error", "Langue inconnue");
		         
		         //GUI
	        	 
	        	 preset.createSection("gui");
	        	 preset.set("gui.ironshop", "§l§8Magasin de fer");
	        	 
	        	 //Objets
	        	 
	        	 preset.createSection("items");
	        	 
	        	 preset.set("items.iron_ingot", "§7Lingot de Fer");
	        	 preset.set("items.gold_ingot", "§6Lingot d'or");
	        	 preset.set("items.diamond", "§bDiamant");
	        	 preset.set("items.emerald", "§2Emeraude");
	        	 
	        	 
	        	 preset.set("items.blockgui", "§fBlocs de construction");
	        	 preset.set("items.woolblock", "Laine");
	        	 preset.set("items.woodblock", "§fPlanche en bois");
	        	 preset.set("items.endstone", "§7Pierre de l'End");
	        	 
	        	 
	        	 preset.set("items.swordgui", "§7Epées");
	        	 preset.set("items.stonesword", "§7Epée en pierre");
	        	 preset.set("items.ironsword", "§7Epée en fer");
	        	 preset.set("items.diamondsword", "§bEpée en Diamant");
	        	 
	        	 preset.set("items.armorgui", "§6Armures");
	        	 preset.set("items.leather_armor", "Armure de cuir");
	        	 preset.set("items.ironarmor", "§7Armure en fer");
	        	 preset.set("items.diamond_armor", "§bArmure en Diamant");
	        	 
	        	 preset.set("items.toolgui", "§6Outils");
	        	 preset.set("items.woodpick", "§7Pioche en bois");
	        	 preset.set("items.woodaxe", "§7Hache en bois");
	        	 preset.set("items.shears", "§7Cisailles");

	        	 preset.set("items.bowgui", "§6Arcs");
	        	 preset.set("items.normalbow", "§fArc");
	        	 preset.set("items.punchbow", "§2Arc Frappe I");
	        	 preset.set("items.arrow", "§fFlèches");
	        	 
	        	 preset.set("items.potgui", "§2Potions");

	        	 preset.set("items.utilgui", "§aUtilitaires");
	        	 preset.set("items.tnt", "§4TNT");

	        	 //Custom messages
	        	 preset.set("messages.kill.0_1", " §fa detruit");
	        	 preset.set("messages.kill.0_2", "§f dans un combat épic");
	        	 
	        	 preset.set("messages.void.0", " §f est tombé dans le vide");
	        	 preset.set("messages.void.1", "§f pensait pouvoir voler... il a apprit qu'il ne pouvait pas");
	        	 
	             preset.save(f);
	             
	         } catch (IOException exception) {

	             exception.printStackTrace();
	         }
	     }
	     }
	    
	    public static boolean doesExist() {
	    	File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Baidouars").getDataFolder(), File.separator + "lang");
	        File f = new File(userdata, File.separator + "fr_fr.yml");
	        
	        if (!f.exists()) {
	        	 return false;
	        } else {
	        	return true;
	        }
	    }
	    
	    public static FileConfiguration get() {
	    	
	    	File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Baidouars").getDataFolder(), File.separator + "lang");
		    File f = new File(userdata, File.separator + "fr_fr.yml");
		    FileConfiguration lang = YamlConfiguration.loadConfiguration(f);
		    if(doesExist()) {
		    	return lang;
		    } else {
		    	fileCheck();
		    	return lang;
		    }
	    }
}

