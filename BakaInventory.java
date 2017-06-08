package me.bhai.BakaInventory;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class BakaInventory extends JavaPlugin {
	
	@Override
	public void onEnable(){
		PluginDescriptionFile pdf = this.getDescription();
		String PluginName = pdf.getName();
		String PluginVersion = pdf.getVersion();
		getLogger().info("Enabled " + PluginName + " v" + PluginVersion + "!");
		getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
	}
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdf = this.getDescription();
		String PluginName = pdf.getName();
		String PluginVersion = pdf.getVersion();
		getLogger().info("Disabling " + PluginName + " v" + PluginVersion + "...");
	}
	

	    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (cmd.getName().equalsIgnoreCase("inventory")) {
            if (!(sender instanceof Player)) {
                return false;
            }

            Player player = (Player) sender;
            
            ItemStack inventoryItem = setMeta(new ItemStack(Material.PAPER) , ChatColor.YELLOW + "Extra Inventory Space", Arrays.asList("Personal Inventory Space" , " Use /inventory to get this item again"));
            
            player.getInventory().addItem(inventoryItem);
        }
        
        return true;
    }
    
    public ItemStack setMeta(ItemStack material, String name, List<String> lore) {
        if (((material == null) || material.getType() == Material.AIR) || (name == null && lore == null)) {
            return null;
        }
        
        ItemMeta im = material.getItemMeta();
        
        if (name != null) {
            im.setDisplayName(name);
        }
        if (lore != null) {
            im.setLore(lore);
        }
        
        material.setItemMeta(im);
        return material;
    }
    
}