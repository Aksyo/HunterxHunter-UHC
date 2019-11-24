package net.hunter.main;

import net.hunter.gameconfig.GameState;
import net.hunter.gameconfig.RoleNumberAcquiredConfiguration;
import net.hunter.gameconfig.RoleNumberAcquiredWrapper;
import net.hunter.gameconfig.WorldSizeConfiguration;
import net.hunter.gameroles.GameRole;
import net.hunter.gameroles.RoleInput;
import net.hunter.tasks.PlayerCountTask;
import net.hunter.utils.HunterGamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main extends JavaPlugin {


    public List<String> uhcRolesName = new ArrayList<String>();
    private GameState state;
    RoleInput input;

    @Override
    public void onEnable() {

       getCommand("roleconfig").setExecutor(new RoleNumberAcquiredConfiguration(this, new RoleNumberAcquiredWrapper(this)));
       getCommand("mapconfig").setExecutor(new WorldSizeConfiguration());

       setState(GameState.WAIT);
       input = new RoleInput();

       Iterator it = RoleInput.uhcRoles.listIterator();
       int i = 0;
       while (it.hasNext()){ uhcRolesName.add(RoleInput.uhcRoles.get(i + 1).getRoleName()); }

       runPlayerCountTask();

    }

    @Override
    public void onDisable() {

    }

    public boolean isState(GameState state){
        return this.state == state;
    }

    public void setState(GameState state){
        this.state = state;
    }

    public void runPlayerCountTask(){

        PlayerCountTask playerCountTask = new PlayerCountTask(this, new RoleNumberAcquiredWrapper(this));
        playerCountTask.runTaskTimer(this, 0L, 20L);

    }





}
