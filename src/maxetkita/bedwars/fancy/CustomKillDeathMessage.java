package maxetkita.bedwars.fancy;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import maxetkita.bedwars.managers.TeamsManager;

public class CustomKillDeathMessage {
//Do something
	
	public static String KillMessage(FileConfiguration config, Player victim, Player killer) { //config : main.getConfig(), victim : killed, killer : killer lol
		Random rdm = new Random();
		int i = rdm.nextInt(0);
		
		ChatColor vcolor = TeamsManager.getPlayerTeamColor(config, victim);
		ChatColor kcolor = TeamsManager.getPlayerTeamColor(config, killer);
		String vname = victim.getDisplayName();
		String kname = killer.getDisplayName();
		
		String msg = vcolor + vname + " §fdied of an unknown death";
		switch(i) { //Penser à créer une traduction
		case 0:
			msg = kcolor + kname + " §fDestroyed " + vcolor + vname + " §f in an epic fight"; //Message type
			break;
		case 1:
			
			break;
		}
		
		return msg;
	}
	
	public static String VoidkilledMessage(FileConfiguration config, Player victim, Player killer) { //qlq push ds le vide
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
	
	public static String VoidMessage(FileConfiguration config, Player victim) {
		Random rdm = new Random();
		int i = rdm.nextInt(2);
		
		ChatColor vcolor = TeamsManager.getPlayerTeamColor(config, victim);
		String vname = victim.getDisplayName();
		
		String msg = vcolor + vname + " §f fell into the void";
		switch(i) { //Penser à créer une traduction
		case 0:
			msg = vcolor + vname + "§f thought he could fly... he learnt he couldnt";
			break;
		case 1:
			msg = vcolor + vname + " §ffell into the void";
			break;
		}
		
		return msg;
	}
	
	public static String FireDeathMessage(FileConfiguration config, Player victim) {
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
