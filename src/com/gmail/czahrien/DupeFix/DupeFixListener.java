package com.gmail.czahrien.DupeFix;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class DupeFixListener implements Listener {
    
    DupeFix mySandbox;
    
    public DupeFixListener(DupeFix s) {
        mySandbox = s;
    }
    
    @EventHandler
    public void dupeFix(InventoryClickEvent e) {
        /**
         * Prevent a malformed item stack on the cursor from doing anything bad...
         */
        int amt = e.getCursor().getAmount();
        if(amt <= 0 && !e.getCursor().getType().equals(Material.AIR)) {
            HumanEntity h = e.getWhoClicked();
            if(h instanceof Player) {
                mySandbox.getLogger().info("[!!!] " + ((Player)h).getDisplayName() + " possibly attempted to dupe id " + e.getCurrentItem().getType().getId() + ".");
            } else {
                mySandbox.getLogger().info("[???] Non-Player human entity. Has id " + e.getCurrentItem().getType().getId() + " on cursor.");
            }
            e.setCursor(new ItemStack(Material.AIR));
            e.setCancelled(true);
        }
    }
    
}
