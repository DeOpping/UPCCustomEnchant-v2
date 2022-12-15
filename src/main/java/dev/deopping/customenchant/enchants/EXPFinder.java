package dev.deopping.customenchant.enchants;

import dev.drawethree.ultraprisoncore.enchants.UltraPrisonEnchants;
import dev.drawethree.ultraprisoncore.enchants.model.UltraPrisonEnchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BasicEnchant extends UltraPrisonEnchantment {

    public BasicEnchant(UltraPrisonEnchants ultraPrisonEnchants, int i) {
        super(ultraPrisonEnchants, i);
    }



    @Override
    public String getAuthor() {
        return "Mantice";
    }
    


    @Override
    public void onEquip(Player player, ItemStack itemStack, int i) {

    }



    @Override
    public void onUnequip(Player player, ItemStack itemStack, int i) {

    }



    @Override
    public void onBlockBreak(BlockBreakEvent blockBreakEvent, int i) {

    }



    @Override
    public double getChanceToTrigger(int i) {
        return 0;
    }



}