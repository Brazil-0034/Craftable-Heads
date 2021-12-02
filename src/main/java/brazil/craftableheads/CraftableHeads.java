package brazil.craftableheads;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import brazil.craftableheads.commands.HeadFetcher;
import brazil.piranesi.commands.DebugCommands;

public class CraftableHeads extends JavaPlugin implements Listener {
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		
        getCommand("head").setExecutor(new SkullFetcher());
	}
}
