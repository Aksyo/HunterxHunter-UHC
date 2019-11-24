package net.hunter.gameroles;

import net.hunter.main.Main;

import java.util.Iterator;

public enum GameRole {

    Gon("§2Gon", 1),
    Kirua("§9Kirua", 1),
    Fourmis("§7Fourmis", 5),
    Roi("§eRoi des Fourmis", 1),
    Hunter("§fHunter", 8),
    Brigadier("§5Brigade Fantome", 2),
    President("§2President", 1);


    String name;
    int numberAcquired;
    private Main main;

    GameRole(String name, int numberAcquired){
        this.name = name;
        this.numberAcquired = numberAcquired;
    }

    public String getRoleName() { return name; }

    public int getNumberAcquired(){ return numberAcquired;}

    public void setNumberAcquired(int numberAcquired){
        this.numberAcquired = numberAcquired;
    }

    public Main getMain() {
        return main;
    }


    public GameRole getRoleByName(String name){

        if(getMain().uhcRolesName.contains(name)){

            Iterator it = RoleInput.uhcRoles.listIterator();
            Boolean isFound = false;
            int index = 0;

            while (!isFound && it.hasNext()){

               if( RoleInput.uhcRoles.get(index + 1).getRoleName() == name){

                   index++;
                   isFound = true;
                   return RoleInput.uhcRoles.get(index);

               }

            }

        }

        return null;
    }
}
