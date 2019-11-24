package net.hunter.utils;

import net.hunter.gameroles.GameRole;
import org.bukkit.entity.Player;



public class HunterGamePlayer {

    private Player p;
    private GameRole role;

    public HunterGamePlayer(Player p, GameRole role){

        this.p = p;
        this.role = role;

    }

    public GameRole getRole() {
        return role;
    }

    public void setRole(GameRole role) {
        this.role = role;
    }
}
