package me.bhai.BakaInventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerListener implements Listener {
	
	BakaInventory plugin;
	Inventory inv = null;
	
	public PlayerListener(BakaInventory pl) {
		plugin = pl;
		
	}

	@EventHandler
	public void onRightClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
			ItemMeta im = p.getInventory().getItemInMainHand().getItemMeta();
			
			if(im.getDisplayName() != null && im.getDisplayName().equals(ChatColor.YELLOW + "Extra Inventory Space")) {
				if(inv == null) {
					Inventory inventory = Bukkit.createInventory(null, 36, "Extra Inventory Space");
					setInventory(inventory);
				}
				p.openInventory(getInventory());
			}
		}
		
	}
	
	public void setInventory(Inventory inv) {
		this.inv = inv;
	}
	
	public Inventory getInventory() {
		return inv;
	}
}
