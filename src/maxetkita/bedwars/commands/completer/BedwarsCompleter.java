package maxetkita.bedwars.commands.completer;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class BedwarsCompleter implements TabCompleter{

	@Override
	public List<String> onTabComplete(CommandSender s, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			List<String> arg = new ArrayList<>();
			
			arg.add("preset");
			
			return arg;
		} else if(args.length == 2) {
			List<String> arg = new ArrayList<>();
			
			switch(args[0]) {
				case "preset":
					arg.add("create");
					arg.add("load");
					arg.add("delete");
					arg.add("enable");
					arg.add("disable");
					arg.add("list");
					arg.add("current");
					break;
			}
			
			return arg;
		} else if(args.length == 3) {
			List<String> arg = new ArrayList<>();
			
			switch(args[0]) {
			case "preset":
				if(!args[2].equals("enable") || !args[2].equals("disable")) {
					arg.add("<name>");
				}
				break;
			}
			
			return arg;
		}
		return null;
	}

}
