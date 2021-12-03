package brazil.craftableheads;

import java.sql.Time;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class SkullFetcher implements CommandExecutor {
	private PlayerCooldownManager pcm;
	
	public SkullFetcher(PlayerCooldownManager p)
	{
		pcm = p;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) return false;
		if (!(sender instanceof Player)) return false;
		
		Player p = (Player) sender;
		String buyerName = p.getName();
		String headName = args[0];
		
		Date currentTime = new Date();
		
		if (!checkPlayerOnline(headName)) {
			p.sendMessage(ChatColor.RED + headName + " isn't online right now.");
			return true;
		}
		
		// check if player cooldown is >= 30m
		Date lastUsageTime = pcm.getLastUsageTime(buyerName);
		long timeDifference = lastUsageTime.getTime() - currentTime.getTime();
		timeDifference /= 60000; //convert to minutes
		if (Math.abs(timeDifference) >= 30)
		{
			SkullBuilder skull = new SkullBuilder(headName, p.getName());
			
			p.getInventory().addItem(skull.buildSkull());
			p.sendMessage(ChatColor.LIGHT_PURPLE + "Received " + headName + "'s skull.");
			
			pcm.updatePlayer(buyerName, currentTime);
		}
		else
		{
			int timeDelay = (int) (30 - timeDifference);
			p.sendMessage(ChatColor.LIGHT_PURPLE + "You must wait an additional " + timeDelay + " minutes before requesting another head.");
		}
		return true;
	}

	private boolean checkPlayerOnline(String headName) {
		for (Player p : Bukkit.getOnlinePlayers())
		{
			if (p.getName().equals(headName)) return true;
		}
		return false;
	}

}
