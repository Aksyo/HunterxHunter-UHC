package net.hunter.tasks;

import net.hunter.gameconfig.GameState;
import net.hunter.gameconfig.RoleNumberAcquiredWrapper;
import net.hunter.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerCountTask extends BukkitRunnable {

    private Main main;
    private RoleNumberAcquiredWrapper roleNumberAcquiredWrapper;
    public PlayerCountTask(Main main, RoleNumberAcquiredWrapper roleNumberAcquiredWrapper){
        this.main = main;
        this.roleNumberAcquiredWrapper = roleNumberAcquiredWrapper;
    }

    private Integer cnt = 31;

    @Override
    public void run() {

        if(main.isState(GameState.WAIT)) {

            if (cnt <= 0 && Bukkit.getOnlinePlayers().size() == roleNumberAcquiredWrapper.getRoleNumberAfterConfig()) {

                main.setState(GameState.START);

                cancel();

            }else if(cnt <= 1 && Bukkit.getOnlinePlayers().size() < 2){

                for (Player p : Bukkit.getOnlinePlayers()){

                    p.setExp(0F);
                    p.setLevel(cnt);

                }

                Bukkit.broadcastMessage("§c§lPas assez de joueur pour commencer");
                cancel();

            }else if(cnt >= 1 && Bukkit.getOnlinePlayers().size() >= 2){

                cnt--;

                for(Player p  : Bukkit.getOnlinePlayers()){

                    p.setExp(0F);
                    p.setLevel(cnt);
                    p.getInventory().clear();

                    p.setWalkSpeed((float) 0.2);
                    p.setAllowFlight(false);

                }

            }

        }

    }
}
