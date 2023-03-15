package maxetkita.bedwars.fancy;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import maxetkita.bedwars.Bedwars;
import maxetkita.bedwars.managers.LanguagesManager;
import maxetkita.bedwars.managers.TeamsManager;

public class CustomKillDeathMessage {
 //Do something
	
	static FileConfiguration lang;
	
	public static String KillMessage(Bedwars main, Player victim, Player killer) { //config : main.getConfig(), victim : killed, killer : killer lol
		lang = LanguagesManager.getLang(main);
		FileConfiguration config = main.getConfig();
		Random rdm = new Random();
		int i = rdm.nextInt(0);
		
		ChatColor vcolor = TeamsManager.getPlayerTeamColor(config, victim);
		ChatColor kcolor = TeamsManager.getPlayerTeamColor(config, killer);
		String vname = victim.getDisplayName();
		String kname = killer.getDisplayName();
		
		String msg = vcolor + vname + " §fdied of an unknown death";
		switch(i) { //Penser à créer une traduction
		case 0:
			msg = kcolor + kname + lang.getString("messages.kill.0_1") + vcolor + vname + lang.getString("messages.kill.0_2"); //Message type
			break;
		case 1:
			
			break;
		}
		
		return msg;
	}
	
	public static String VoidkilledMessage(Bedwars main, Player victim, Player killer) { //qlq push ds le vide
		lang = LanguagesManager.getLang(main);
		FileConfiguration config = main.getConfig();
		Random rdm = new Random();
		int i = rdm.nextInt(0);
		
		ChatColor vcolor = TeamsManager.getPlayerTeamColor(config, victim);
		ChatColor kcolor = TeamsManager.getPlayerTeamColor(config, killer);
		String vname = victim.getDisplayName();
		String kname = killer.getDisplayName();
		
		String msg = vcolor + vname + "§fwas pushed into the void";
		switch(i) { //Penser à créer une traduction
		case 0:
			msg = vcolor + vname + " §fwas pushed into the void";
			break;
		case 1:
			msg = kcolor + kname + " §ftaught to " + vcolor + vname + "§f how to fly";
			break;
		}
		
		return msg;
	}
	
	public static String VoidMessage(Bedwars main, Player victim) {
		lang = LanguagesManager.getLang(main);
		FileConfiguration config = main.getConfig();
		Random rdm = new Random();
		int i = rdm.nextInt(2);
		
		ChatColor vcolor = TeamsManager.getPlayerTeamColor(config, victim);
		String vname = victim.getDisplayName();
		
		String msg = vcolor + vname + lang.getString("messages.void.0");
		switch(i) { //Penser à créer une traduction
		case 0:
			msg = vcolor + vname + lang.getString("messages.void.0");
			break;
		case 1:
			msg = vcolor + vname + lang.getString("messages.void.1");
			break;
		}
		
		return msg;
	}
	
	public static String FireDeathMessage(Bedwars main, Player victim) {
		lang = LanguagesManager.getLang(main);
		FileConfiguration config = main.getConfig();
		Random rdm = new Random();
		int i = rdm.nextInt(2);
		
		ChatColor vcolor = TeamsManager.getPlayerTeamColor(config, victim);
		String vname = victim.getDisplayName();
		
		String msg = vcolor + vname + " §fburnt to the death";
		switch(i) { //Penser à créer une traduction
		case 0:
			msg = vcolor + vname + "§f now smells like a BBQ";
			break;
		case 1:
			msg = vcolor + vname + " §fseems to really like the fire... too much maybe ?";
			break;
		}
		
		return msg;
	}
}
