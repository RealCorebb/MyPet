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

import de.Keyle.MyPet.MyPetApi;
import de.Keyle.MyPet.api.util.hooks.PluginHookName;
import de.Keyle.MyPet.api.util.hooks.types.PlayerVersusEntityHook;
import de.Keyle.MyPet.api.util.hooks.types.PlayerVersusPlayerHook;
import me.angeschossen.lands.api.enums.LandsAction;
import me.angeschossen.lands.api.landsaddons.LandsAddon;
import me.angeschossen.lands.api.objects.LandChunk;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

@PluginHookName("Lands")
public class LandsHook implements PlayerVersusEntityHook, PlayerVersusPlayerHook {

    private LandsAddon landsAddon;
    private String key;

    @Override
    public boolean onEnable() {
        landsAddon = new LandsAddon(MyPetApi.getPlugin(), false);
        key = landsAddon.initialize();
        return key != null;
    }

    @Override
    public void onDisable() {
        landsAddon.disable(key);
    }

    @Override
    public boolean canHurt(Player attacker, Entity defender) {
        if (!(defender instanceof Animals)) {
            return true;
        }
        try {
            LandChunk landChunk = landsAddon.getLandChunk(defender.getLocation().getChunk());
            if (landChunk == null) {
                return true;
            }
            return landChunk.canAction(attacker.getUniqueId().toString(), LandsAction.ATTACK_ANIMAL);
        } catch (Throwable ignored) {
        }
        return true;
    }

    @Override
    public boolean canHurt(Player attacker, Player defender) {
        try {
            LandChunk landChunk = landsAddon.getLandChunk(defender.getLocation().getChunk());
            if (landChunk == null) {
                return true;
            }
            return landChunk.canAction(attacker.getUniqueId().toString(), LandsAction.ATTACK_PLAYER);
        } catch (Throwable ignored) {
        }
        return true;
    }
}