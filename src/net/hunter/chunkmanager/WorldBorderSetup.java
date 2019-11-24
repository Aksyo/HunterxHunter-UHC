package net.hunter.chunkmanager;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;

public class WorldBorderSetup {

    public WorldBorderSetup(World world, int worldSize){

        WorldBorder worldBorder = Bukkit.getWorld(world.getName()).getWorldBorder();
        worldBorder.setCenter(0, 0);
        worldBorder.setSize(worldSize);

    }


}
