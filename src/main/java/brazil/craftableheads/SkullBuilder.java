package brazil.craftableheads;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullBuilder {
	private String targetName;
	private String buyerName;
	
	public SkullBuilder(String target, String buyer)
	{
		targetName = target;
		buyerName = buyer;
	}
	
	public ItemStack buildSkull()
	{
		ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
		
		SkullMeta skullData = (SkullMeta) skull.getItemMeta();

		//set the skull to the player
		skullData.setOwningPlayer(Bukkit.getOfflinePlayer(targetName));
		// attribute the buyer
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.LIGHT_PURPLE + targetName + "'s Skull. Ordered by " + buyerName);
		
		skullData.setLore(lore);
		
		skull.setItemMeta(skullData);
		
		return skull;
	}
}
