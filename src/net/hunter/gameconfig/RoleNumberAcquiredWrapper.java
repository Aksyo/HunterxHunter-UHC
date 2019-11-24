package net.hunter.gameconfig;


import net.hunter.gameroles.GameRole;
import net.hunter.gameroles.RoleInput;
import net.hunter.main.Main;


import java.util.Iterator;

public class RoleNumberAcquiredWrapper {

    private Main main;


    public RoleNumberAcquiredWrapper(Main main){
        this.main = main;
    }

    public void roleSetNumberAcquired(String roleName, int numberAcquired){


            if(main.uhcRolesName.contains(roleName)){

                Iterator it = RoleInput.uhcRoles.listIterator();
                Boolean isFound = false;
                int index = 0;

                while (!isFound && it.hasNext()){

                    if( RoleInput.uhcRoles.get(index + 1).getRoleName() == roleName){

                        index++;
                        isFound = true;
                        RoleInput.uhcRoles.get(index).setNumberAcquired(numberAcquired);

                    }

                }

            }
    }

    public Integer getRoleNumberAfterConfig(){

        int index = 0;
        Integer numberAq = 0;
        Iterator it = RoleInput.uhcRoles.listIterator();

        while (it.hasNext()){

            index++;
            numberAq = numberAq + RoleInput.uhcRoles.get(index).getNumberAcquired();


        }
        return numberAq;


    }

}
