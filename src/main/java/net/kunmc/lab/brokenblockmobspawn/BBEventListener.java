package net.kunmc.lab.brokenblockmobspawn;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BBEventListener implements Listener {

    static List<EntityType> entities = Arrays.asList(
            EntityType.BAT,
            EntityType.BEE,
            EntityType.BLAZE,
            EntityType.CAT,
            EntityType.CAVE_SPIDER,
            EntityType.CHICKEN,
            EntityType.COD,
            EntityType.COW,
            EntityType.DOLPHIN,
            EntityType.DONKEY,
            EntityType.DROWNED,
            EntityType.ELDER_GUARDIAN,
            EntityType.ENDERMAN,
            EntityType.ENDERMITE,
            EntityType.EVOKER,
            EntityType.FOX,
            EntityType.GIANT,
            EntityType.GHAST,
            EntityType.GUARDIAN,
            EntityType.HUSK,
            EntityType.LLAMA,
            EntityType.MAGMA_CUBE,
            EntityType.MULE,
            EntityType.MUSHROOM_COW,
            EntityType.OCELOT,
            EntityType.PANDA,
            EntityType.PARROT,
            EntityType.PHANTOM,
            EntityType.PIG,
            //EntityType.PIG_ZOMBIE,
            EntityType.POLAR_BEAR,
            EntityType.PUFFERFISH,
            EntityType.RABBIT,
            EntityType.SHEEP,
            EntityType.SHULKER,
            EntityType.SILVERFISH,
            EntityType.SKELETON,
            EntityType.SLIME,
            EntityType.SPIDER,
            EntityType.SQUID,
            EntityType.STRAY,
            EntityType.VILLAGER,
            EntityType.WITCH,
            EntityType.WITHER,
            EntityType.WITHER_SKELETON,
            EntityType.WOLF,
            EntityType.ZOMBIE,
            EntityType.ZOMBIE_HORSE,
            EntityType.ZOMBIE_VILLAGER
    );

    @EventHandler
    public static void BlockBreak(BlockBreakEvent e) {
        int r = new java.util.Random().nextInt(BrokenBlockMobSpawn.probability);
        if(r==0) {
            Collections.shuffle(entities);
            Location loc = e.getBlock().getLocation();
            loc.getWorld().spawnEntity(loc, entities.get(0));
            loc.getWorld().spawnParticle(Particle.CLOUD,loc,10);
        }
    }

}
