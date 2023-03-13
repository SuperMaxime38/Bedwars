package maxetkita.bedwars;

import org.bukkit.plugin.java.JavaPlugin;

import maxetkita.bedwars.commands.BWTeamCommand;
import maxetkita.bedwars.commands.BedwarsCommand;
import maxetkita.bedwars.commands.DebugCommand;
import maxetkita.bedwars.commands.completer.BedwarsCompleter;
import maxetkita.bedwars.lang.LangEN;
import maxetkita.bedwars.lang.LangFR;
import maxetkita.bedwars.listeners.DeathListener;
import maxetkita.bedwars.managers.BedBrokenManager;
import maxetkita.bedwars.managers.DamageManager;
import maxetkita.bedwars.managers.KBManager;
import maxetkita.bedwars.shop.IronNPC;


public class Bedwars extends JavaPlugin{

	@Override
	public void onEnable() {
		saveDefaultConfig();
		LangEN.fileCheck();
		LangFR.fileCheck();
		getCommand("bedwars").setExecutor(new BedwarsCommand(this));
		getCommand("bwteam").setExecutor(new BWTeamCommand(this));
		getCommand("bwdebug").setExecutor(new DebugCommand(this));
		getServer().getPluginManager().registerEvents(new DamageManager(this), this);
		getServer().getPluginManager().registerEvents(new IronNPC(this), this);
		getServer().getPluginManager().registerEvents(new KBManager(this), this);
		getServer().getPluginManager().registerEvents(new DeathListener(this), this);
		getServer().getPluginManager().registerEvents(new BedBrokenManager(this), this);
		getCommand("bedwars").setTabCompleter(new BedwarsCompleter());
		System.out.println("[Baidouars] > Plugin enabled !");
	}
	
	@Override
	public void onDisable() {
		//saveConfig();
	}
}
