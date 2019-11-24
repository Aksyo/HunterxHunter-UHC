package net.hunter.gameroles;

import net.hunter.main.Main;

import java.util.ArrayList;
import java.util.List;

public class RoleInput {

    public static List<GameRole> uhcRoles = new ArrayList<GameRole>();

    public RoleInput() {

        uhcRoles.add(GameRole.Gon);
        uhcRoles.add(GameRole.Kirua);
        uhcRoles.add(GameRole.Hunter);
        uhcRoles.add(GameRole.President);
        uhcRoles.add(GameRole.Fourmis);
        uhcRoles.add(GameRole.Roi);
        uhcRoles.add(GameRole.Brigadier);

    }
}
