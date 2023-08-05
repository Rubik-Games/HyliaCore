package net.swofty.lobby.npc.npcs;

import net.swofty.lobby.Data;
import net.swofty.lobby.Loader;
import net.swofty.lobby.manager.PlayerManager;
import net.swofty.lobby.npc.NPC;
import net.swofty.lobby.npc.NPCParameters;
import net.swofty.lobby.util.BookGUI;
import net.swofty.lobby.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;

@NPCParameters(
        idname = "[NPC] Tutorial",
        name = "§7",
        id = 5,
        signature = "ll34a/xBZd5jX9qxHns+A00RwUAbyrapBd4JcfSqfHfeWWp1Ko1FzYi42I6iLihJDn5v3pCoV0/pDG++ih4rmhBrT47H7LmrN7ZHCUfrU2kMTqMNJo9NJAWtm90lrGfi8D5uMBDO83wxXi/BJBgIAj8uNFSmNis03TBxz6ORmkkNj8P7sec56AzW+4Cir86VyHyn5w7ZN/hbBAYvZBwYzoUS2b+8FraRfrDz5D1znl5Cosy78q8q/wPVWJh2ZbW4fgFalqxdx6yiSUfmV+BoN2/0z5WJM2F5QDe1zzB8JgaBHq74CqQvcacmQxJpl/hqet9ShDJdGVhj1u4T4LOMxfV7PykDoF/5/utgeyNhzIYnJQUn/FwKgbSLszfqBkMqsxrqsXQeofqRfelx/CFFtsuG9U7g9Gn+uUgCSJI53jP9qbosZKevEvSzVd7Ons59rvwoQQAeVR0hxal87ABTlmU17z98hJ8zB08gIw/jzMxERT32x7L6cM21+DKBINA/ELmdkxAymHyW8rFtvHt71PuyQykzEbE/OUKWpjMg85EbuT67QP9PSAPUMPvf+H49KJh6zVFEbWDfHFGqavNOdqPJEqZIM4xzRWYSYxjvWKoWpmaDWxQmJC+2iEzlmwaMf6eiIxviU2RviIbe2703iXVivQOd0jVPFnt/92kTIUU=",
        texture = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDZlNDQzOGJkMjM3ZGIzMjU5YmUxZTdkM2YxZTVkMjg0YTVjYmNmZjgzNDJjOTkzMDk1YTJmZTVhODc5OGQxZCJ9fX0=",

        world = "world",
        x = 13.5,
        y = 72,5
        z = 17.5,

        looking = true
)
public class TutorialNPC extends NPC {

    public static ArrayList<Player> tutorial1 = new ArrayList<>();
    public static ArrayList<Player> tutorial2 = new ArrayList<>();
    public static ArrayList<Player> tutorial3 = new ArrayList<>();
    public static ArrayList<Player> tutorial4 = new ArrayList<>();
    public static ArrayList<Player> tutorial5 = new ArrayList<>();


    @Override
    public void onClick(PlayerClickNPCEvent event) {

        event.getPlayer().setGameMode(GameMode.SPECTATOR);
        tutorial1.add(event.getPlayer());
        event.getPlayer().sendMessage(" ");
        event.getPlayer().sendMessage("§e§lBienvenido a Hylia,");
        event.getPlayer().sendMessage("§bdale a la brujula para jugar.");
        event.getPlayer().sendMessage(" ");

        event.getPlayer().sendTitle("§e§lBienvenido a Hylia,", "§bdale a la brujula para jugar.");

        new BukkitRunnable() {
            @Override
            public void run() {

                tutorial1.remove(event.getPlayer());
                tutorial2.add(event.getPlayer());
                event.getPlayer().sendMessage("§e§lTambien puedes");
                event.getPlayer().sendMessage("§bdarle click-derecho a los npcs.");
                event.getPlayer().sendMessage(" ");


                event.getPlayer().sendTitle("§e§lTambien puedes", "§bdarle click-derecho a los npcs.");

                new BukkitRunnable() {
                    @Override
                    public void run() {

                        tutorial2.remove(event.getPlayer());
                        tutorial3.add(event.getPlayer());
                        event.getPlayer().sendMessage("§e§lMira tu inventario.");
                        event.getPlayer().sendMessage("§bTienes logros, cosmeticos y mas!");
                        event.getPlayer().sendMessage(" ");

                        event.getPlayer().sendTitle("§e§lMira tu inventario.", "§bTienes logros, cosmeticos y mas!");

                        new BukkitRunnable() {
                            @Override
                            public void run() {

                                tutorial3.remove(event.getPlayer());
                                tutorial4.add(event.getPlayer());
                                event.getPlayer().sendMessage("§e§lVisita nuestra web!");
                                event.getPlayer().sendMessage("§bwww.hyliamc.net - Noticias, discusiones y mas!");
                                event.getPlayer().sendMessage(" ");

                                event.getPlayer().sendTitle("§e§lVisita nuestra web!", "§bwww.hyliamc.net - Noticias, discusiones y mas!");

                                new BukkitRunnable() {
                                    @Override
                                    public void run() {

                                        tutorial4.remove(event.getPlayer());
                                        tutorial5.add(event.getPlayer());
                                        event.getPlayer().sendMessage("§e§lEso es todo!");
                                        event.getPlayer().sendMessage("§bPasalo bien en el servidor!");
                                        event.getPlayer().sendMessage(" ");

                                        event.getPlayer().sendTitle("§e§lEso es todo!", "§bPasalo bien en el servidor!");

                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {

                                                tutorial5.remove(event.getPlayer());
                                                event.getPlayer().setGameMode(GameMode.SURVIVAL);
                                                event.getPlayer().resetTitle();

                                            }
                                        }.runTaskLater(Loader.getInstance(), 60);

                                    }
                                }.runTaskLaterAsynchronously(Loader.getInstance(), 80);

                            }
                        }.runTaskLaterAsynchronously(Loader.getInstance(), 80);

                    }
                }.runTaskLaterAsynchronously(Loader.getInstance(), 80);

            }
        }.runTaskLaterAsynchronously(Loader.getInstance(), 80);

    }
}
