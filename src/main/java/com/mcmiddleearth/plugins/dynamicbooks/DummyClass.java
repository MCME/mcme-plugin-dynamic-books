package com.mcmiddleearth.plugins.dynamicbooks;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class DummyClass {
   private final Set<Player> alreadyConnected = new HashSet<>();

    public boolean isFirstTimeJoining(Player player) {
        if (alreadyConnected.contains(player)) {
            return false;
        } else {
            alreadyConnected.add(player);
            return true;
        }
    }
}
