package dev.deopping.customenchant;

import dev.deopping.customenchant.enchants.EXPFinder;
import dev.drawethree.ultraprisoncore.UltraPrisonCore;
import dev.drawethree.ultraprisoncore.enchants.UltraPrisonEnchants;
import dev.drawethree.ultraprisoncore.enchants.api.UltraPrisonEnchantsAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        initialize();

        // Register Enchants
        api.registerEnchant(new EXPFinder(this, 101));

        getLogger().info("CustomEnchant " + getDescription().getVersion() + " enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomEnchant " + getDescription().getVersion() + " disabled!");
    }



    private void initialize() {
        if (getServer().getPluginManager().getPlugin("UltraPrisonCore") == null) {
            getLogger().info("This plugin requires UltraPrisonCore!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.upc = UltraPrisonCore.getInstance();

        if (!upc.isModuleEnabled(UltraPrisonEnchants.MODULE_NAME)) {
            getLogger().info("UltraPrisonCore Enchants module is disabled!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        api = upc.getEnchants().getApi();
    }



    private UltraPrisonCore upc;
    public UltraPrisonCore getUPC() { return upc; }

    private UltraPrisonEnchantsAPI api;
    public UltraPrisonEnchantsAPI getApi() { return api; }



}