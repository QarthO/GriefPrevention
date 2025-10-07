package com.griefprevention.handlers;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.persistence.PersistentDataType;

import me.ryanhamshire.GriefPrevention.GriefPrevention;

public class VehicleHandler implements Listener{

    private final NamespacedKey VEHICLE_OWNER = new NamespacedKey(GriefPrevention.instance, "vehicle_owner");

    @EventHandler (ignoreCancelled = true)
    public void onExitVehicle(VehicleExitEvent event) {

        // only care about players
        if(!(event.getExited() instanceof Player player)) return;
        String playerId = player.getUniqueId().toString();
        
        Vehicle vehicle = event.getVehicle();
        vehicle.getPersistentDataContainer().set(VEHICLE_OWNER, PersistentDataType.STRING, playerId);
    }

    public void onEnterVehicle(VehicleEnterEvent event) {

        // only care about players
        if(!(event.getEntered() instanceof Player player)) return;

    }
}
