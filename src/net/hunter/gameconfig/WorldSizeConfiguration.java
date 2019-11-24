package net.hunter.gameconfig;

import net.hunter.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldSizeConfiguration implements CommandExecutor {

    private Main main;
    public WorldSizeConfiguration(Main main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

        if(!(s instanceof Player) || !(s.hasPermission("hunter.config.map"))){
            return true;
        }
        if(main.isState(GameState.START) || main.isState(GameState.PLAY)){
            s.sendMessage("§cTu peux seulement modifier la map au lobby d'attente."); return true;}

        if(args.length > 0){
            s.sendMessage("§c/hrm");
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("mapconfig") || cmd.getName().equalsIgnoreCase("hmc")){



        }



        return false;
    }
}
