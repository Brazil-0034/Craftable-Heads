package brazil.craftableheads;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CraftableHeads extends JavaPlugin implements Listener {
	public void onEnable()
	{
		PlayerCooldownManager pcm = new PlayerCooldownManager();
		
		getServer().getPluginManager().registerEvents(this, this);
		
        getCommand("head").setExecutor(new SkullFetcher(pcm));
	}
}
