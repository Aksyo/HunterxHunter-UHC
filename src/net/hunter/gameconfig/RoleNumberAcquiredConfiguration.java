package net.hunter.gameconfig;

import net.hunter.gameroles.GameRole;
import net.hunter.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RoleNumberAcquiredConfiguration implements CommandExecutor {

    private RoleNumberAcquiredWrapper roleNumberAcquiredWrapper;
    private Main main;
    public RoleNumberAcquiredConfiguration(Main main, RoleNumberAcquiredWrapper roleNumberAcquiredWrapper){
        this.main = main;
        this.roleNumberAcquiredWrapper = roleNumberAcquiredWrapper;
    }



    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

        if(!s.hasPermission("hunter.role.config") || !(s instanceof Player)){ return true; }
        if(main.isState(GameState.START) || main.isState(GameState.PLAY)){
            s.sendMessage("§cTu peux seulement modifier les roles au lobby d'attente."); return true;}

        if(args.length == 2){

            if(cmd.getName().equalsIgnoreCase("roleconfig") || cmd.getName().equalsIgnoreCase("hrc")){

                if (main.uhcRolesName.contains(args[0].toString())) {

                    roleNumberAcquiredWrapper.roleSetNumberAcquired(args[0].toString(), Integer.parseInt(args[1]));

                }

            }

            s.sendMessage(ChatColor.RED + "/hrc <role> <number>");

        }

        return false;
    }
}
