package dev.deopping.customenchant.enchants;

import dev.deopping.customenchant.Core;
import dev.drawethree.ultraprisoncore.UltraPrisonCore;
import dev.drawethree.ultraprisoncore.enchants.UltraPrisonEnchants;
import dev.drawethree.ultraprisoncore.enchants.model.UltraPrisonEnchantment;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class EXPFinder extends UltraPrisonEnchantment {

    private final UltraPrisonCore upc;

    public EXPFinder(Core core, int i) {
        super(UltraPrisonEnchants.getInstance(), i);
        this.upc = core.getUPC();
    }



    @Override
    public String getAuthor() {
        return "Mantice";
    }



    @Override
    public void onEquip(Player player, ItemStack itemStack, int level) {}

    @Override
    public void onUnequip(Player player, ItemStack itemStack, int level) {}



    @Override
    public void onBlockBreak(BlockBreakEvent event, int level) {

        Player player = event.getPlayer();
        YamlConfiguration cfg = upc.getEnchants().getEnchantsConfig().getYamlConfig();
        String path = "enchants.101.";

        double chance = cfg.getDouble(path + "Chance");
        if (chance * level < ThreadLocalRandom.current().nextDouble(100)) return;

        String maxString = cfg.getString(path + "Max-Exp").replace("{LEVEL}", level + "");
        String minString = cfg.getString(path + "Min-Exp").replace("{LEVEL}", level + "");

        Expression maxExpression = new ExpressionBuilder(maxString).build();
        Expression minExpression = new ExpressionBuilder(minString).build();

        double max = maxExpression.evaluate();
        double min = minExpression.evaluate();

        double random = ThreadLocalRandom.current().nextDouble(min, max);
        player.giveExp((int) random);

    }



    @Override
    public double getChanceToTrigger(int i) {
        YamlConfiguration cfg = upc.getEnchants().getEnchantsConfig().getYamlConfig();
        return cfg.getDouble("enchants.101.Chance");
    }



}