/*
 * This file is part of MyPet
 *
 * Copyright © 2011-2018 Keyle
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

package de.Keyle.MyPet.api;

import de.Keyle.MyPet.api.util.ConfigItem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Configuration {
    public static class Misc {
        public static boolean CONSUME_LEASH_ITEM = false;
        public static boolean ALLOW_RANGED_LEASHING = true;
        public static boolean OWNER_CAN_ATTACK_PET = false;
        public static boolean DISABLE_PET_VS_PLAYER = false;
        public static boolean REMOVE_PETS_AFTER_RELEASE = false;
        public static double MYPET_FOLLOW_START_DISTANCE = 7.0F;
        public static boolean RELEASE_PETS_ON_DEATH = false;
        public static boolean RETAIN_EQUIPMENT_ON_TAME = true;
        public static boolean INVISIBLE_LIKE_OWNER = true;
        public static boolean THROW_PLAYER_MOVE_EVENT_WHILE_RIDING = true;
        public static boolean DISABLE_ALL_ACTIONBAR_MESSAGES = false;
        public static String OVERWRITE_LANGUAGE = "";
        public static String WIKI_URL = "https://wiki.mypet-plugin.de";
        public static int MAX_STORED_PET_COUNT = 45;
    }

    public static class Log {
        public static String LEVEL = "INFO";
    }

    public static class Update {
        public static boolean ASYNC = false;
        public static boolean CHECK = true;
        public static boolean DOWNLOAD = false;
        public static boolean REPLACE_OLD = false;
        public static String TOKEN = "";
    }

    public static class Repository {
        public static long EXTERNAL_LOAD_DELAY = 20L;

        public static String REPOSITORY_TYPE = "SQLite";
        public static String CONVERT_FROM = "";

        public static class MySQL {
            public static String DATABASE = "mypet";
            public static String PREFIX = "";
            public static String HOST = "localhost";
            public static String PASSWORD = "";
            public static String USER = "root";
            public static String CHARACTER_ENCODING = "utf8";
            public static int PORT = 3306;
            public static int POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;
        }

        public static class MongoDB {
            public static String DATABASE = "mypet";
            public static String PREFIX = "";
            public static String HOST = "localhost";
            public static String PASSWORD = "";
            public static String USER = "";
            public static int PORT = 27017;
        }
    }

    public static class Respawn {
        public static int TIME_FACTOR = 5;
        public static int TIME_PLAYER_FACTOR = 5;
        public static int TIME_FIXED = 0;
        public static int TIME_PLAYER_FIXED = 0;
        public static double COSTS_FACTOR = 1.0;
        public static double COSTS_FIXED = 0.0;
    }

    public static class Name {
        public static int MAX_LENGTH = 32;

        public static class Tag {
            public static boolean SHOW = true;
            public static String PREFIX = "<aqua>";
            public static String SUFFIX = "";
        }
    }

    public static class Permissions {
        public static boolean ENABLED = true;
        public static boolean EXTENDED = false;
        public static boolean LEGACY = false;
    }

    public static class LevelSystem {
        public static String CALCULATION_MODE = "Default";

        public static class Experience {
            public static int LOSS_PERCENT = 0;
            public static double LOSS_FIXED = 0;
            public static boolean DROP_LOST_EXP = true;
            public static boolean DAMAGE_WEIGHTED_EXPERIENCE_DISTRIBUTION = true;
            public static boolean ALWAYS_GRANT_PASSIVE_XP = true;
            public static int PASSIVE_PERCENT_PER_MONSTER = 25;
            public static int LEVEL_CAP = 100;
            public static Set<String> PREVENT_FROM_SPAWN_REASON = new HashSet<>();
            public static Set<String> DISABLED_WORLDS = new HashSet<>();
        }
    }

    public static class HungerSystem {
        public static boolean USE_HUNGER_SYSTEM = true;
        public static int HUNGER_SYSTEM_TIME = 60;
        public static double HUNGER_SYSTEM_SATURATION_PER_FEED = 6.0;
        public static boolean AFFECT_RIDE_SPEED = true;
        public static boolean AFFECT_BEACON_RANGE = true;
    }

    public static class Skilltree {
        public static int SWITCH_FEE_PERCENT = 5;
        public static double SWITCH_FEE_FIXED = 0.0;
        public static boolean SWITCH_FEE_ADMIN = false;
        public static boolean AUTOMATIC_SKILLTREE_ASSIGNMENT = false;
        public static boolean RANDOM_SKILLTREE_ASSIGNMENT = false;
        public static boolean CHOOSE_SKILLTREE_ONLY_ONCE = false;
        public static boolean PREVENT_LEVELLING_WITHOUT_SKILLTREE = true;
        public static boolean INHERIT_ALREADY_INHERITED_SKILLS = false;

        public static class Skill {
            public static ConfigItem CONTROL_ITEM;

            public static class Ride {
                public static ConfigItem RIDE_ITEM;
                public static double HUNGER_PER_METER = 0.01;
                public static Map<String, Boolean> FLY_ZONES = new HashMap<>();
            }

            public static class Beacon {
                public static int HUNGER_DECREASE_TIME = 100;
                public static boolean PARTY_SUPPORT = true;
            }

            public static class Inventory {
                public static boolean OPEN_IN_CREATIVE = false;
                public static boolean DROP_WHEN_OWNER_DIES = false;
            }
        }
    }

    public static class MyPet {
        public static class Chicken {
            public static ConfigItem GROW_UP_ITEM;
            public static boolean CAN_LAY_EGGS = true;
        }

        public static class Cow {
            public static boolean CAN_GIVE_MILK = true;
            public static ConfigItem GROW_UP_ITEM;
        }

        public static class Sheep {
            public static boolean CAN_BE_SHEARED = true;
            public static boolean CAN_REGROW_WOOL = true;
            public static ConfigItem GROW_UP_ITEM;
        }

        public static class IronGolem {
            public static boolean CAN_THROW_UP = true;
        }

        public static class Snowman {
            public static boolean FIX_SNOW_TRACK = true;
        }

        public static class Horse {
            public static ConfigItem GROW_UP_ITEM;
        }

        public static class Llama {
            public static ConfigItem GROW_UP_ITEM;
        }

        public static class Mooshroom {
            public static ConfigItem GROW_UP_ITEM;
            public static boolean CAN_GIVE_SOUP;
        }

        public static class Ocelot {
            public static ConfigItem GROW_UP_ITEM;
        }

        public static class Pig {
            public static ConfigItem GROW_UP_ITEM;
        }

        public static class Villager {
            public static ConfigItem GROW_UP_ITEM;
        }

        public static class Wolf {
            public static ConfigItem GROW_UP_ITEM;
        }

        public static class Zombie {
            public static ConfigItem GROW_UP_ITEM;
        }

        public static class PigZombie {

            public static ConfigItem GROW_UP_ITEM;
        }

        public static class Rabbit {
            public static ConfigItem GROW_UP_ITEM;
        }
    }

    public static class Hooks {
        public static boolean USE_ECONOMY = true;
        public static boolean DISABLE_PETS_IN_MINIGAMES = true;
        public static boolean DISABLE_PETS_IN_ARENA = true;
        public static boolean DISABLE_PETS_IN_SURVIVAL_GAMES = true;
        public static boolean DISABLE_PETS_IN_HUNGER_GAMES = true;
        public static boolean DISABLE_MYTHIC_MOB_LEASHING = true;
        public static boolean USE_Towny = true;
        public static boolean USE_Factions = true;
        public static boolean USE_WorldGuard = true;
        public static boolean USE_Citizens = true;
        public static boolean USE_Heroes = true;
        public static boolean USE_McMMO = true;
        public static boolean USE_SimpleClans = true;
        public static boolean USE_RedProtect = true;
        public static boolean USE_Residence = true;
        public static boolean USE_AncientRPG = true;
        public static boolean USE_GriefPrevention = true;
        public static boolean USE_PvPArena = true;
        public static boolean USE_PvPManager = true;
        public static boolean USE_SurvivalGame = true;
        public static boolean USE_Kingdoms = true;
        public static boolean USE_PlotSquared = true;
        public static boolean USE_PvPDiffTimer = true;
        public static boolean USE_PreciousStones = true;

        public static class SkillAPI {
            public static boolean GRANT_EXP = true;
            public static boolean DISABLE_VANILLA_EXP = false;
            public static int EXP_PERCENT = 100;
        }

        public static class MobArena {
            public static boolean ENABLED = true;
            public static boolean ALLOW_PETS = true;
            public static boolean RESPECT_PVP_RULE = true;
        }
    }
}