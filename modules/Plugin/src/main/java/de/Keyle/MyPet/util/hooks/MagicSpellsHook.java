/*
 * This file is part of MyPet
 *
 * Copyright © 2011-2019 Keyle
 * MyPet is licensed under the GNU Lesser General Public License.
 *
 * MyPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MyPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package de.Keyle.MyPet.util.hooks;

import com.nisovin.magicspells.events.SpellTargetEvent;
import de.Keyle.MyPet.MyPetApi;
import de.Keyle.MyPet.api.entity.MyPetBukkitEntity;
import de.Keyle.MyPet.api.util.hooks.PluginHook;
import de.Keyle.MyPet.api.util.hooks.PluginHookName;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;

@PluginHookName("MagicSpells")
public class MagicSpellsHook implements PluginHook {

    @Override
    public boolean onEnable() {
        Bukkit.getPluginManager().registerEvents(this, MyPetApi.getPlugin());
        return true;
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    @EventHandler
    public void onPlayerExpGain(SpellTargetEvent event) {
        if (event.getTarget() instanceof MyPetBukkitEntity) {
            if (((MyPetBukkitEntity) event.getTarget()).getOwner().equals(event.getCaster())) {
                event.setCancelled(true);
            } else if (!MyPetApi.getHookHelper().canHurt(event.getCaster(), ((MyPetBukkitEntity) event.getTarget()).getOwner().getPlayer())) {
                event.setCancelled(true);
            }
        }
    }
}