package com.gmail.czahrien.DupeFix;

import org.bukkit.plugin.java.JavaPlugin;

public class DupeFix extends JavaPlugin {
    DupeFixListener list;
    public void onEnable() {
        list = new DupeFixListener(this);
        getServer().getPluginManager().registerEvents(list,this);
    }
    
    public void onDisable() {
        
    }
}
